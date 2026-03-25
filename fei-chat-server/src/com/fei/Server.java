package com.fei;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    //定义一个集合容器存储所有登录进来的客户端管道，以便将来群发消息给他们
    //定义一个MAP集合，键是客户端的管道，值客户端的管道用户名称
    public static Map<Socket,String> onlinesocket = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("服务器启动......");
        try {
            //1.注册端口
            ServerSocket serverSocket = new ServerSocket(Constant.PORT);
            //2.主线程负责接受客户端的连接请求
            System.out.println("等待客户端连接......");
            while (true) {
                //3.用accept()方法,获取客户端Socket对象
                Socket socket = serverSocket.accept();
                //4.把管道交给独立的一个线程来处理，以便支持多个客户端连接
                new ServerReaderThread(socket).start();

                System.out.println("一个客户端连接了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
