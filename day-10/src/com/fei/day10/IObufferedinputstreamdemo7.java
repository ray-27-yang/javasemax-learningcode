package com.fei.day10;

import java.io.*;

public class IObufferedinputstreamdemo7 {
    public static void main(String[] args) {
        //目标：掌握缓冲字节输入流的使用
        copy("C:\\Users\\20691\\Desktop\\yuri\\复制样本.jpg", "C:\\Users\\20691\\Desktop\\电吉他\\复制样本-copy.jpg");
    }
    public static void copy(String srcPath, String destPath){
        try (
                //1.创建输入流
                InputStream in = new FileInputStream(srcPath);
                //把低级流包装成创建缓冲字节输入流
                InputStream in1 = new BufferedInputStream(in);
                //2.创建输出流
                OutputStream out = new FileOutputStream(destPath);
                //把低级流包装成创建缓冲字节输出流
                OutputStream out1 = new BufferedOutputStream(out);
        ){
            //3.开始复制
            //先定义一个桶
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in1.read(buffer)) != -1){
                out1.write(buffer,0,len);//读入多少就写入多少
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

