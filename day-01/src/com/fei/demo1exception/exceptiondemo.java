package com.fei.demo1exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class exceptiondemo {
    //目标：认识异常体系
    public static void main(String[] args) {
        show();
        //监视代码，出现异常，会被catch拦截
        try {
            show1();
        } catch (ParseException e) {
            e.printStackTrace();//打印异常信息
        }

    }
    //定义一个方法认识运行时异常
    public static void show(){
        System.out.println("==程序开始==");
        int[] arr = {0,1,2};
        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
        System.out.println(10/0);//ArithmeticException
        String str = null;
        System.out.println(str);//null
        System.out.println(str.length());//NullPointerException
        System.out.println("==程序结束==");

    }
    //定义一个方法认识编译时异常
    public static void show1() throws ParseException {//把方法内部异常往外抛
        System.out.println("==程序开始==");
        String str = "2025-11-23 21:43";
        //把字符串时间解析成java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(str);//ParseException，编译时异常：提醒程序员这里的程序很容易出错，请注意
        System.out.println(date);
    }

}
