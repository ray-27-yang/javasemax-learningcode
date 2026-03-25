package com.fei.executorService;

import java.util.concurrent.Callable;

public class MyCollable implements Callable<String> {
    private int n;

    public MyCollable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "计算1-" + n + "的和为：" + sum;
    }
}
