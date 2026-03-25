package com.fei.javase10;

public class threadtest2 {
    public static void main(String[] args) {
        //2.创建线程任务对象
        Runnable r = new MyRunnable();
        Thread t = new Thread(r,"线程1");//public Thread(Runnable target, String name)
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
        }
    }
}
//1.定义一个线程任务类实现接口
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程任务："+i);
        }
    }
}