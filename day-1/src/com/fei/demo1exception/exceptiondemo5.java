package com.fei.demo1exception;

import java.util.Scanner;

public class exceptiondemo5 {
    public static void main(String[] args) {
        //目标：掌握异常处理方案2：捕获异常对象，尝试修复让程序继续进行
        //主要运用到了一个死循环来实现
        //接受用户的一个定价
        System.out.println("==程序开始==");//打印日志
        while (true) {
            try {
                double price = getPrice();
                System.out.println("价格是："+ price);//若用户乱输入一个，程序会挂
                break;
            } catch (Exception e) {
                System.out.println("价格输入有误，请重新输入");
                e.printStackTrace();
            }
        }
        System.out.println("==程序结束==");
    }
    public static double getPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个价格：");
        double price = sc.nextDouble();
        return price;
    }
}
