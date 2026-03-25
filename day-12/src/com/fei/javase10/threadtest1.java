package com.fei.javase10;

public class threadtest1 {
    //main方法本身是由主线程创建的
    public static void main(String[] args) {
        //4.创建一个线程对象
        Thread t1 = new MyThread();
        //5.启动线程
        t1.start();//启动线程，启动后会自动调用run方法
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程任务代码 " + i);
        }
    }
}
//1.定义一个子类继承线程类
class MyThread extends Thread{
    //2.重写thread类的run方法
    @Override
    public void run() {
        //3.在run方法中编写线程的任务代码
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程任务代码" + i);
        }
    }
}
