package com.fei.day2;

import java.util.ArrayList;

public class genericdemo6 {
    public static void main(String[] args) {
        //目标：把基本数据类型变成包装类对象（包装数据类型）
        //手工包装
        //Integer i = new Integer(10);过时了
        Integer i = Integer.valueOf(10);//i表示对象100
        //其实是包装好了一个-128到128的数据，直接取就行了，节约内存
        Integer i1 = Integer.valueOf(10);
        System.out.println("i == i"); // true,取的是同一个地址
        Integer i2 = Integer.valueOf(130);
        Integer i3 = Integer.valueOf(130);
        System.out.println("i == i1");// false,超出范围，各自创建新的对象，地址不一样了

        //自动装箱：自动包装成对象
        Integer i4 = 10;
        //自动拆箱：对象变成基本数据类型
        int i5 = i4;
        //
        ArrayList<Integer> list = new ArrayList<>();
        list.add(130);//自动装箱
        int i6 = list.get(0);//自动拆箱:取的是对象，但可以用int接，因为可以自动拆箱

        //包装类新增功能
        //1.把基本数据类型变成字符串
        int j = 10;
        String s = Integer.toString(j);//也可自动转换成对象，然后调方法
        System.out.println(s + 1);//结果不是11，而是101
        //但是以上内容也鸡助可以直接
        String s1 = j + "";
        //2.把字符串变成基本数据类型
        String s2 = "10";
        //int j1 = Integer.parseInt(s2);
        int j1 = Integer.valueOf(s2);
        System.out.println(j1 + 1);//结果是11
        String s3 = "8.3";
        //double d = Double.parseDouble(s3);
        double d = Double.valueOf(s3);
    }
}
