package com.geek.concurrent.practice.practice23_26;

import java.util.concurrent.*;

/**
 * @ClassName CompletionServiceSample
 * @Description 用于解决批量执行异步任务，异步并行执行时，通过future.get串行获取结果，
 * 前一个future.get会阻塞后一个future.get，无法保证先执行完的先处理
 * @Author xuery
 * @Date 2019/5/31 15:45
 * @Version 1.0
 */
public class CompletionServiceSample {

    public static void main(String[] args) throws Exception {

        //土方法
        ExecutorService es = Executors.newFixedThreadPool(6);
        Future<Integer> f1 = es.submit(() -> {
            SleepUtils.sleep(3000);
            return 1;
        });

        Future<Integer> f2 = es.submit(() -> {
            SleepUtils.sleep(2000);
            return 2;
        });

        Future<Integer> f3 = es.submit(() -> {
            SleepUtils.sleep(1000);
            return 3;
        });

        BlockingQueue<Integer> bq = new LinkedBlockingDeque<>(3);

        es.submit(() -> {
            try {
                bq.put(f1.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                bq.put(f2.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                bq.put(f3.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        });


        for (int i = 0; i < 3; i++) {
            Integer result = bq.take();
            System.out.println(result);
        }

        //CompletionService 把我们上面的放入阻塞队列的事给封装了
        ExecutorService es2 = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(es2);
        cs.submit(()->{
            SleepUtils.sleep(3000);
            return 1;
        });

        cs.submit(()->{
            SleepUtils.sleep(2000);
            return 2;
        });

        cs.submit(()->{
            SleepUtils.sleep(1000);
            return 3;
        });

        for(int i=0;i<3;i++){
            System.out.println(cs.take().get());
//
//            System.out.println(cs.poll().get());

//            System.out.println(cs.poll(900,TimeUnit.MILLISECONDS).get());
        }

    }
}
