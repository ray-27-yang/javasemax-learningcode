package com.fei.day10;

import java.io.*;

public class copydemo3 {
    public static void main(String[] args) {
        //目标：使用文件字节输入流，将文件复制到另一个文件
        copy("C:\\Users\\20691\\Desktop\\yuri\\复制样本.jpg", "C:\\Users\\20691\\Desktop\\电吉他\\复制样本-copy.jpg");
    }
    public static void copy(String srcPath, String destPath){
        //在外面定义使final里面能拿到
        OutputStream out = null;
        InputStream in = null;
        try {
            //1.创建输入流
            in = new FileInputStream(srcPath);
            //2.创建输出流
            out = new FileOutputStream(destPath);
            //3.开始复制
            //先定义一个桶
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1){
                out .write(buffer,0,len);//读入多少就写入多少
            }
            System.out.println("复制完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
