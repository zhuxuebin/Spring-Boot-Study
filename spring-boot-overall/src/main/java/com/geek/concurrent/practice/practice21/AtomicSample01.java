package com.geek.concurrent.practice.practice21;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicSample01
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 10:37
 * @Version 1.0
 */
public class AtomicSample01 {

    private final CountDownLatch cdl = new CountDownLatch(2);

    long count = 0;

    AtomicInteger atomicCount = new AtomicInteger(0);

    public void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
            atomicCount.getAndAdd(1);
        }
    }

    public static void main(String[] args) throws Exception {

        AtomicSample01 sample01 = new AtomicSample01();
        Thread t1 = new Thread(() -> {
            sample01.add10K();
        });

        Thread t2 = new Thread(()->{
            sample01.add10K();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(sample01.count);
        System.out.println(sample01.atomicCount);
    }
}
