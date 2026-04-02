package UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了");
        //1.创建接收端对象，注册端口
        DatagramSocket socket = new DatagramSocket(2007);
        //2.创建数据包对象，封装接收数据
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.接收数据
        socket.receive(packet);
        int len = packet.getLength();
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        //4.查看数据是否接受到了
        String data = new String(buf,0,len);
        System.out.println("数据来自于：" + ip + "端口号是：" + port);
    }
}
