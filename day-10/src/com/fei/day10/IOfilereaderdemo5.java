package com.fei.day10;

import java.io.FileReader;

public class IOfilereaderdemo5 {
    public static void main(String[] args) throws Exception {
        //目标：文件字符输入流
        //1.创建一个文件字符输入流与原文件接通
        try (
                FileReader fr = new FileReader("day-10\\src\\demo2")
        ) {
            //2.开始读取
            char[] buffer = new char[1024];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
