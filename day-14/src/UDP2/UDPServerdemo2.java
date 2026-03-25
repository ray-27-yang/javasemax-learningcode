package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServerdemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动了");

        DatagramSocket socket = new DatagramSocket(2007);

        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        while (true) {
            socket.receive(packet);
            int len = packet.getLength();
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            String data = new String(buf,0,len);
            System.out.println(data + " 数据来自于：" + ip + "端口号是：" + port);
            System.out.println("======================================");
        }
    }
}
