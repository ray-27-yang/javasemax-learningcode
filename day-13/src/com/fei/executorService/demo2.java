package com.fei.executorService;

import java.util.concurrent.*;

public class demo2 {
    public static void main(String[] args) {
        //目标创建线程池对象并使用
        //1.使用线程池的实现类ThreadPoolExecutor申明7个参数来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //使用线程池执行任务，看会不会重复复用线程
        Future<String> f1 = pool.submit(new MyCollable(100));
        Future<String> f2 = pool.submit(new MyCollable(200));
        Future<String> f3 = pool.submit(new MyCollable(300));
        Future<String> f4 = pool.submit(new MyCollable(400));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
