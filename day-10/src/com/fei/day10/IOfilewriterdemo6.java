package com.fei.day10;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.Writer;

public class IOfilewriterdemo6 {
    public static void main(String[] args){
        //目标：字符输出流
        //1.创建字符输出流管道
        try (
                Writer os = new FileWriter("day-10\\src\\demo3");
                //追加模式
                Writer os1 = new FileWriter("day-10\\src\\demo3", true);

                ) {
            //2.开始写字符数据
            os.write(97);
            os.write('b');
            os.write('杨');
            //3.写字符串
            os.write("yangan");
            os.write("yangan",1,2);//截取字符串
            //4.写字符数组
            char[] chars = {'a','b','c'};
            char[] chars1 = "abcd".toCharArray();
            os.write(chars);
            os.write(chars1,0,2);
            // 5.刷新缓冲区
            os.flush();//刷新缓冲区，将数据写入文件,刷新缓冲区后，流可以继续使用，不会关闭
            os.close();//关闭流，将缓冲区数据写入文件，包含刷新缓冲区，关闭文件，流不可以继续使用
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
