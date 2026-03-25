package com.fei.javase10;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class threadtest3 {
    public static void main(String[] args) {
        //2.创建线程任务对象
        Callable<String> c = new MyCallable(100);
        //3.把callable任务对象封装成一个真正的线程任务对象
        /**
         * 未来任务对象的作用
         *   a.本身是一个线程任务对象，可以交给Thread线程对象从而得到线程
         *   b.可以得到callable任务执行后的结果
         */
        FutureTask<String> f = new FutureTask<>(c);
        //4.把FutureTask任务对象交给Thread线程对象，从而得到线程
        Thread t = new Thread(f);
        t.start();

        Callable<String> c2 = new MyCallable(50);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();

        //5.取线程任务执行后的结果
        try {
            //若发现第一个线程没有执行完毕，会让出CPU，阻塞方法，等线程任务执行完毕，并返回结果才往下执行
            System.out.println(f.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//1.定义一个实现类实现callable接口
class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程计算1-"+ n +"的和为："+ sum;
    }
}