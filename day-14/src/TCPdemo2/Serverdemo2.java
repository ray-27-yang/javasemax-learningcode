package TCPdemo2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo2 {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下多发多收收服务端的创建
        System.out.println("服务端启动了");
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            String data = dis.readUTF();//等待客户端发送的文本
            System.out.println("服务端收到数据："+data);
            System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
            System.out.println("客户端的端口："+socket.getPort());
            System.out.println("----------------------------------");
        }
    }
}
