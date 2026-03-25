package com.fei.executorService;

import java.util.concurrent.*;

public class demo1 {
    public static void main(String[] args) {
        //目标创建线程池对象并使用
        //1.使用线程池的实现类ThreadPoolExecutor申明7个参数来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //使用线程池执行任务，看会不会重复复用线程
        Runnable task = new MyRunnable();
        pool.execute(task);//提交第一个任务，创建第一个线程，自动启动线程，执行任务
        pool.execute(task);//提交第二个任务，创建第二个线程，自动启动线程，执行任务
        pool.execute(task);//提交第三个任务，创建第三个线程，自动启动线程，执行任务
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);//到了创建临时线程的时机
        pool.execute(task);//又创建一个临时线程
        pool.execute(task);//拒绝任务，使用拒绝策略









        //6.关闭线程池对象，一般不关闭线程池
//        pool.shutdown();//等所有任务执行完毕后会关闭线程池
//        pool.shutdownNow();//不等所有任务执行完毕，直接关闭线程池
    }
}
