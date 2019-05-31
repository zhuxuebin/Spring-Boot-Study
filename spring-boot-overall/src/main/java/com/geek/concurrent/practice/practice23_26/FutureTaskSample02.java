package com.geek.concurrent.practice.practice23_26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskSample02
 * @Description 采用Future并行执行T1，T2，等T1/T2都执行完了再执行T3
 * @Author xuery
 * @Date 2019/5/31 14:28
 * @Version 1.0
 */
public class FutureTaskSample02 {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);

        FutureTask<String> ft1 = new FutureTask<>(() -> {
            System.out.println("烧开水");
            SleepUtils.sleep(1000);
            return "t1";
        });

        FutureTask<String> ft2 = new FutureTask<>(() -> {
            System.out.println("洗茶壶");
            SleepUtils.sleep(1000);
            return "t2";
        });

        es.submit(ft1);
        es.submit(ft2);

        try {
            System.out.println(ft1.get());
            System.out.println(ft2.get());
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("泡茶");
    }
}
