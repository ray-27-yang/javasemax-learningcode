package com.fei.day10;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSet {
    public static void main(String[] args) throws Exception {
        //目标：写程序实现字符的编码与解码
        //1.编码
        String str = "四面佛";
        byte[] bytes = str.getBytes();//平台默认编码
        //byte[] bytes1 = str.getBytes();
        //byte[] bytes2 = str.getBytes("GBK");
        byte[] bytes2 = str.getBytes("GBK");//指定编码
        System.out.println(Arrays.toString(bytes));// 数组转字符串
        System.out.println(Arrays.toString(bytes2));
        //2.解码
        String name2 = new String(bytes);//用构造器解码
        String name3 = new String(bytes2, "GBK");
    }
}
