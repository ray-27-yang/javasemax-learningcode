package com.fei;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //接受的消息可能有很多形式 1.登录消息（包含昵称）2.群发消息 3.私聊消息
            //客户端必须声明协议发送消息
            //比如客户端先发1，代表登录，发2，代表群发，发3，代表私聊
            //先从socket管道中接受客户端送来的消息类型编号
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while (true) {
                int type = dis.readInt();//应该放到循环里面
                switch (type) {
                    case 1:
                        //1.客户端发来了登录消息，接下来接受昵称数据，再更新全部在线列表的在线人数
                        String nickname = dis.readUTF();
                        //把这个登录成功的客户端的socket管道保存到集合中
                        Server.onlinesocket.put(socket, nickname);
                        //更新全部客户端的在线人数列表
                        updateSocketOnlineList();
                        break;

                    case 2:
                        //2.群发消息，接受消息内容，然后把消息内容发送给所有在线的管道
                        String msg = dis.readUTF();//接受消息内容
                        sendMsgToAll(msg);
                        break;

                    case 3:
                        //3.私聊消息，接受消息内容，然后把消息内容发送给指定的管道
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("客户端下线了：" + socket.getInetAddress().getHostAddress());
            Server.onlinesocket.remove(socket);//把下线的客户端socket从在线集合中移除
            updateSocketOnlineList();//下线了用户也需要更新全部客户端的在线人数列表
        }
    }

    //给全部在线socket推送当前客户端发来的消息
    private void sendMsgToAll(String msg) {
        //一定要拼装好这个消息再发给全部socket
        StringBuilder sb = new StringBuilder();
        String name = Server.onlinesocket.get(socket);
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        String nowdtf = now.format(dtf);
        //拼装消息
        String msgResult = sb.append(name).append(" ").append(nowdtf).append("\r\n").append(msg).append("\r\n").toString();
        //推送
        for (Socket socket : Server.onlinesocket.keySet()) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);//发送消息类型编号,告诉客户端接下来发送在线人数列表信息，2代表群发消息，3代表私聊消息
                dos.writeUTF(msgResult);
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

        private void updateSocketOnlineList () {
            //更新客户端全部在线人数列表
            //拿到全部在线客户端的用户名称，把这些名称发送给全部在线的管道
            //1.拿到全部在线的用户昵称
            Collection<String> onlineUsers = Server.onlinesocket.values();
            //2.把昵称发送给全部在线的管道
            for (Socket socket : Server.onlinesocket.keySet()) {
                try {
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeInt(1);//发送消息类型编号,告诉客户端接下来发送在线人数列表信息，2代表群发消息，3代表私聊消息
                    dos.writeInt(onlineUsers.size());//发送在线人数，客户端可知道循环读取多少次
                    for (String user : onlineUsers) {
                        dos.writeUTF(user);
                    }
                    dos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

