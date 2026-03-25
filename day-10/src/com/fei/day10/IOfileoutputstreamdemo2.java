package com.fei.day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IOfileoutputstreamdemo2 {
    public static void main(String[] args) throws Exception {
        //目标：学习文件字节输出流
        //1.将文件字节输出流管道与文件接通
        //覆盖管道，先会清空文件，再写入数据
        OutputStream os  = new FileOutputStream("day-10\\src\\demo2");
        //追加管道，不会清空文件，追加数
        OutputStream os1  = new FileOutputStream("day-10\\src\\demo2",true);

        //2.开始写数据
        os.write(97);
        os.write('b');
        os.write('杨');//一共三个字节，读第一个字节进去，会乱码
        os.write("\r\n".getBytes());//换行符,兼容性更好
        //3.写一个字节数组
        //byte[] bytes = {97,98,99};
        //："abc".getBytes() 将字符串对象 "abc" 转换为对应的字节数组 [97, 98, 99]（ASCII 码值）
        byte[] bytes = "abc".getBytes();
        os.write(bytes);
        //4.写字节数组的一部分
        os.write(bytes,0,2);
        //5.关闭流
        os.close();



    }
}
