package com.fei.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class IObufferedreaderdemo8 {
    public static void main(String[] args) {
        //目标：掌握缓冲字符输入流使用
        //目标：文件字符输入流
        //1.创建一个文件字符输入流与原文件接通
        try (
                Reader fr = new FileReader("day-10\\src\\demo2");
                BufferedReader fr1 = new BufferedReader(fr);
        ) {
            //2.开始读取
//            System.out.println(fr1.readLine());
//            System.out.println(fr1.readLine());
//            System.out.println(fr1.readLine());
            //3.循环读取改进代码
            //创建一个变量，保存读取到的数据
            String line;
            while ((line = fr1.readLine()) != null){
                System.out.println(line);
            }
            //这是目前读取文本最优雅的方案
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
