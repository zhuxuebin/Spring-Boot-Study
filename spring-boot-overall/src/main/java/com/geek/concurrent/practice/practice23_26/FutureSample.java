package com.geek.concurrent.practice.practice23_26;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName FutureSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 14:03
 * @Version 1.0
 */
public class FutureSample {

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Result result = new Result();
        result.setAAA(123);

        Future<Result> future = executorService.submit(new Task(result),result);

        Result result1 = future.get();

        System.out.println("result.AAA="+result1.getAAA());
        System.out.println("result.XXX="+result1.getXXX());
    }

    private static class Task implements Runnable{
        Result result;
        public Task(Result result) {
            this.result = result;
        }


        @Override
        public void run() {
            System.out.println("Task.result.AAA="+result.getAAA());
            result.setXXX(456);
        }
    }

    private static class Result{
        int AAA;
        int XXX;

        public int getAAA() {
            return AAA;
        }

        public void setAAA(int AAA) {
            this.AAA = AAA;
        }

        public int getXXX() {
            return XXX;
        }

        public void setXXX(int XXX) {
            this.XXX = XXX;
        }
    }
}
