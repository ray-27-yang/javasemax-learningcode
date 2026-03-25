package TCPdemo2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Clientdemo2 {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP通信下多发多收客户端
        System.out.println("客户端启动了");
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数据：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                System.out.println("客户端退出");
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();//刷新
        }
    }
}
