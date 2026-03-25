package TCPdemo4BS;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Serverdemo2 {
    public static void main(String[] args) throws Exception {
        //目标：BS架构理解
        System.out.println("服务端启动了");
        ServerSocket ss = new ServerSocket(8080);
        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket socket = ss.accept();
            System.out.println("一个客户端连接了"+socket.getInetAddress().getHostAddress());
            //1.把这个客户端管道包装成一个任务交给线程池处理
            pool.execute(new ServerReader(socket));//线程对象本身可以当任务对象使用
        }
    }
}
