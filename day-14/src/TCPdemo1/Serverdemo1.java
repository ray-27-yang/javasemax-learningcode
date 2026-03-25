package TCPdemo1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo1 {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下一发一收服务端的创建
        System.out.println("服务端启动了");
        //1.创建一个服务器ServerSocket对象，绑定端口号，监听客户端的连接
        ServerSocket ss = new ServerSocket(8888);
        //2.调用accept方法，阻塞客户端连接，一旦有客户端连接，返回一个Socket对象
        Socket socket = ss.accept();
        //3.获取输入流，读取数据
        InputStream is = socket.getInputStream();
        //4.把字节输入流包装成特殊数据输入流
        DataInputStream dis = new DataInputStream(is);
        //5.读取数据
        String data = dis.readUTF();
        int age = dis.readInt();
        System.out.println("服务端收到数据："+data+"---"+age);
        //6.客户端的IP与端口
        System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
        System.out.println("客户端的端口："+socket.getPort());
    }
}
