package com.fei.ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientReaderThread extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private ClientChatFrame win;

    public ClientReaderThread(Socket socket, ClientChatFrame win) {
        this.socket = socket;
        this.win = win;
    }

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //接受的消息可能有很多形式 1.在线人数更新数据2.群发消息 3.私聊消息
            dis = new DataInputStream(socket.getInputStream());//由于dis是全局变量，为了给后面方法使用，所以这里用成员变量，不用局部变量
            while (true) {
                int type = dis.readInt();
                switch (type) {
                    case 1:
                        //1.服务端发来的在线人数更新消息
                        updateClientOnlineUserList();
                        break;

                    case 2:
                        //2.服务端发送来的群聊消息
                        getMsgToWin();

                        break;

                    case 3:
                        //3.私聊消息，接受消息内容，然后把消息内容发送给指定的管道
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// 更新在线人数列表
    private void updateClientOnlineUserList() throws Exception {
        //1.读取服务端发来的在线人数个数
        int count = dis.readInt();

        //2.循环读取用户信息
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            String nickname = dis.readUTF();
            //3.将信息添加到集合中
            names[i] = nickname;
        }

        //5.更新到窗口右侧展示
        win.updateOnlineUsers(names);
    }

// 群聊消息
    public void getMsgToWin() throws Exception {
        String msg = dis.readUTF();
        win.setMsgToWin(msg);
    }
}

