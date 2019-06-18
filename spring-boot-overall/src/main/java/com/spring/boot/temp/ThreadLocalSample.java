package com.spring.boot.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLocalSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/1 14:38
 * @Version 1.0
 */
public class ThreadLocalSample {

    private static ThreadLocal<String> threadLocalStr = new ThreadLocal<>();

    public static void main(String[] args) {

        //复现下ThreadLocal变量结合线程池的坑
        ExecutorService es = Executors.newFixedThreadPool(1);

        es.submit(new Task1());

        es.submit(new Task2());


    }

    //设置ThreadLocal
    static class Task1 implements Runnable {

        @Override
        public void run() {
            //获取本线程的threadLocalStr
            String threadLoacalGet = threadLocalStr.get();
            System.out.println("task1 name=" + Thread.currentThread().getName());
            if (threadLoacalGet == null) {
                threadLoacalGet = new String(Thread.currentThread().getName());
                threadLocalStr.set(threadLoacalGet);
            }
        }
    }

    //不设置ThreadLocal 看下能否获取到（如果是和之前的Task1复用线程则可能获取到）
    static class Task2 implements Runnable {

        @Override
        public void run() {
            //获取本线程的threadLocalStr
            String threadLoacalGet = threadLocalStr.get();
            System.out.println("task2 " + Thread.currentThread().getName() + " threadLocalStr=" + threadLoacalGet);
        }
    }
}
