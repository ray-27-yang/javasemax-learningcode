package com.fei.day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IOfileinputstreamdemo1 {
    public static void main(String[] args) throws Exception {
        //1.创建通道
        //通向文件对象与通向文件路径没有区别，后者会包装一个File对象，再获取File对象
        //InputStream is = new FileInputStream(new File("day-10\\src\\demo1"));
        InputStream is = new FileInputStream("day-10\\src\\demo1");//简化写法
        //InputStream is1 = new FileInputStream("")

        //2.读取字节并输出，读取一个字节
//        //定义一个变量记住每次读取的一个字节
//        int b;
//        while ((b = is.read()) != -1) {
//            System.out.print((char) b);
//        }
        //每次读取一个字节性能较差，读取汉字输出一定乱码
        //2.读取字节并输出，读取多个字节
        //定义一个字节数组每次读取字节
        byte[] buffer = new byte[3];
        //定义一个变量记住每次读取的字节个数
        int len;
        while ((len = is.read(buffer)) != -1) {
            String s = new String(buffer, 0, len);
            System.out.print(s);// yangan
        }
        //每次读取多个字节，性能得到提升，因为每次读取多个字符，可以减少硬盘和内存的交互次数，从而提升性能
        //一次性读完全部字节
        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));
    }
}
