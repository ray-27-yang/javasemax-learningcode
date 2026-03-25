package com.fei.day10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class IObufferedwriterdemo9 {
    public static void main(String[] args) {
        //目标：缓冲字符输出流
        //1.创建字符输出流管道
        try (
                //Writer bw = new FileWriter("day-10\\src\\demo3");
                //追加模式
                Writer os = new FileWriter("day-10\\src\\demo3", true);
                //缓冲字符输出流
                BufferedWriter bw = new BufferedWriter(os);
        ) {
            //2.开始写字符数据
            bw.write(97);
            bw.write('b');
            bw.write('杨');
            bw.newLine();//换行
            //3.写字符串
            bw.write("yangan");
            bw.write("yangan",1,2);//截取字符串
            //4.写字符数组
            char[] chars = {'a','b','c'};
            char[] chars1 = "abcd".toCharArray();
            bw.write(chars);
            bw.write(chars1,0,2);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
