package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServerdemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动：");
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (true){
            socket.receive(packet);
            int len = packet.getLength();
            int p = packet.getPort();
            String ip = packet.getAddress().getHostAddress();
            String data = new String(buf,0,len);
            System.out.println("接收到来自" + ip + "地址的数据" + data);
        }
    }
}
