package printstream;

import java.io.FilterOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class demo1 {
    public static void main(String[] args) {
        //目标：打印流的使用
        try(
                PrintStream ps = new PrintStream("day-10\\src\\demo4");
                //追加模式（低级管道才能追加）
                //PrintStream ps = new PrintStream(new FilterOutputStream("day-10\\src\\demo4", true));
                //PrintWriter ps = new PrintWriter("day-10\\src\\demo4");
                ){
            ps.println("hello world");
            ps.println(true);
            ps.println(97);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
