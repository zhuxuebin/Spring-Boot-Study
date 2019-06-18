package com.geek.concurrent.practice.practice06;

import com.geek.concurrent.practice.practice23_26.SleepUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName InterruptExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/11 9:51
 * @Version 1.0
 */
public class InterruptExample {

    private static class MyThread implements Runnable{
        @Override
        public void run() {
            while(!Thread.interrupted()){
                //loop
            }
            System.out.println("thread end");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
        SleepUtils.sleep(1000);
        thread.interrupt(); //中断线程
    }
}
