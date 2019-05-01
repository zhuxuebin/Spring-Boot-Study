package com.geek.concurrent.practice.practice19;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 一个线程等待多个线程
 * Created by xuery on 2019/5/1.
 */
public class CountDownLatchSample {

    private static final CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        new Thread(()->{
            try {
                System.out.println("t1");
                Thread.sleep(1000);
                cdl.countDown();
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println("t2");
                Thread.sleep(2000);
                cdl.countDown();
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        cdl.await();

        System.out.println("main");
    }
}
