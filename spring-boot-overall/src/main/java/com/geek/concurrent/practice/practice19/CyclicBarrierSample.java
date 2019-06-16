package com.geek.concurrent.practice.practice19;

import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description 多个线程之间相互等待
 * Created by xuery on 2019/5/1.
 */
public class CyclicBarrierSample<P,D> {
    Vector<P> pos = new Vector<P>();
    Vector<D> dos = new Vector<D>();

    private final Executor executor = Executors.newFixedThreadPool(1);

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
        /**
         * *todo xuery* 这里为什么要用一个线程池开启一个线程执行check呢?这个跟cyclicBarrier执行回调函数的时机有关
         * 回调函数是将计数器减为0的线程执行的，而且是在唤醒其他线程之前至执行的，如果这里不开启一个线程池直接check，
         * 如果check的时间过长，会导致其他线程一直阻塞，起不到多线程提升效率的作用
         */
        executor.execute(()->check());
    });

    public void check(){
        P p = pos.remove(0);
        D d = dos.remove(0);

        //do sth
    }

    public void checkAll(){
        Thread t1 = new Thread(()->{
            //循环查询P/D
            while(true) {
                try {
                    P p = null;//这里实际应该是查询
                    pos.add(p);
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            //循环查询P/D
            while(true) {
                try {
                    D d = null;//这里实际应该是查询
                    dos.add(d);
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    public static void main(String[] args) {
        CyclicBarrierSample<String,String> sample = new CyclicBarrierSample<>();
        sample.checkAll();
    }
}
