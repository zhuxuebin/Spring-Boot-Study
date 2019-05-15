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
