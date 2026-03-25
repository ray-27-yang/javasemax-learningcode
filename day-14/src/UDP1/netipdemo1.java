package UDP1;

import java.net.InetAddress;

public class netipdemo1 {
    public static void main(String[] args) {
        try {
            //获取本机ip对象
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println(ip1);
            //获取指定ip对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip2);
            //获取指定ip对象
            InetAddress ip3 = InetAddress.getByName("192.168.1.1");
            System.out.println(ip3);
            //判断本机与对方主机是否互通
            System.out.println(ip1.isReachable(5000));//true联了网就通了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
