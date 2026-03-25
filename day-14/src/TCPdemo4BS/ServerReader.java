package TCPdemo4BS;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //给当前浏览器响应一个网页过去
            OutputStream os = socket.getOutputStream();
            //把字节输出流包装成打印流（打印换行更方便）
            PrintStream ps = new PrintStream(os);
            //写响应的网页数据出去
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();//空行
            ps.println("<html>");//开始网页标签
            ps.println("<head><title>一入腐门深似海：垂丝海棠欢迎你</title></head>");//头部标签
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size=20px'>收藏榜一：《交易沦陷》by在下小神j</h1>");
            ps.println("</body>");
            ps.println("</html>");

            ps.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("客户端退出"+socket.getInetAddress().getHostAddress());//若客户端退出，则服务端会抛异常，这里处理
        }

    }

}

