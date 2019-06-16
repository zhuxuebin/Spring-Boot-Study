package com.geek.concurrent.practice.practice23_26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 14:23
 * @Version 1.0
 */
public class FutureTaskSample {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(()->1+1);

        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(futureTask);

        Integer result = futureTask.get();
        System.out.println(result);
    }
}
