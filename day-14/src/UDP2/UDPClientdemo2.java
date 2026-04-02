package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientdemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动了");
        //创建客户端管道
        DatagramSocket socket = new DatagramSocket();
        //接受数据
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入要发送的数据：");
            if (sc.nextLine() == "886"){
                System.out.println("客户端退出");
                socket.close();
                break;
            }
            byte[] bytes = sc.nextLine().getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,InetAddress.getLocalHost(),8888);
            socket.send(packet);
        }
    }
}
