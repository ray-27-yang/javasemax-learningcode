package com.fei.javase10;

public class threadtest2_2 {
    //目标：用接口匿名内部类实现多线程
    public static void main(String[] args) {
        //2.创建线程任务对象
        new Thread(() -> System.out.println("---------------")).start();
    }
}

