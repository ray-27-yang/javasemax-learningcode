package com.fei.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo3 {
    public static void main(String[] args) {
        //通过线程池工具类调用其静态方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
    }
}
