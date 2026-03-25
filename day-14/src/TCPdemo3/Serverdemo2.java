package TCPdemo3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo2 {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下多发多收服务端的创建,支持多个客户端连接
        System.out.println("服务端启动了");
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            Socket socket = ss.accept();
            System.out.println("一个客户端连接了"+socket.getInetAddress().getHostAddress());
            //1.把这个客户端管道交给一个独立的子线程专门负责接受这个管道消息
            new ServerReader(socket).start();
        }
    }
}
