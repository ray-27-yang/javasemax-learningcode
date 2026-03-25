package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientdemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动了");

        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String msg = sc.nextLine();//next有空格只收空格前面的数据,nextLine收的范围更大
            byte[] bytes = msg.getBytes();
            if("886".equals(msg)){
                System.out.println("客户端退出");
                socket.close();
                break;
            }
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),2007);
            socket.send(packet);
        }
    }
}
