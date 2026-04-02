package com.fei.demo1exception;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class exceptiondemo4 {
    public static void main(String[] args) {
        //底层异常都抛出到最外层，最外层捕获，记录异常，响应合适信息
        System.out.println("==程序开始==");
        try {
            show();
            System.out.println("==操作成功==");
        } catch (Exception e) {
            e.printStackTrace();//异常栈信息，记录到日志文件
            System.out.println("==操作失败==");//响应合适信息给用户，如一个提示操作有误的网页
        }
        System.out.println("==程序结束==");
    }
    public static void show() throws Exception {//把方法内部异常往外抛
        System.out.println("==程序开始==");
        String str = "2025-11-23 21:43";
        //把字符串时间解析成java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = sdf.parse(str);//ParseException，编译时异常：提醒程序员这里的程序很容易出错，请注意
        System.out.println(date);


    }
}
