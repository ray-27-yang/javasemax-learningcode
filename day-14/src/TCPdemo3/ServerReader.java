package TCPdemo3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //读取子线程的消息
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();//等待客户端发送的文本
                System.out.println("服务端收到数据："+msg);
                System.out.println("客户端的IP："+socket.getInetAddress().getHostAddress());
                System.out.println("客户端的端口："+socket.getPort());
                System.out.println("----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("客户端退出"+socket.getInetAddress().getHostAddress());//若客户端退出，则服务端会抛异常，这里处理
        }

    }

}

