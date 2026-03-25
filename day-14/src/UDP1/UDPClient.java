package UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        //目标：完成客户端依法一收，客户端开发
        System.out.println("客户端启动了");
        //1.创建一个客户端（发送）对象：代表抛韭菜的人
        DatagramSocket socket = new DatagramSocket();//随机端口
        //2.创建数据包对象，封装发送的数据
        byte[] bytes = "客户端向您激情推荐绅士三部曲之一《绅士的庄园》".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),2007);
        //3.发送数据
        socket.send(packet);
    }
}
