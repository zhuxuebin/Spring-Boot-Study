package com.geek.concurrent.practice.practice16;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @ClassName ObjPool
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/30 20:18
 * @Version 1.0
 */
//T代表线程连接的类型，R代表线程池的执行结果返回类型
public class ObjPool<T,R> {

    final List<T> pool;

    final Semaphore semaphore;

    public ObjPool(int size, T t){
        pool = new Vector<>(); //为什么要用Vector,下面的remove存在并发，必须使用线程安全的集合
        semaphore = new Semaphore(size);
        for(int i=0;i<size;i++){
            pool.add(t);
        }
    }

    R execute(Function<T,R> func){
        T t = null;
        try {
            semaphore.acquire();

            t = pool.remove(0);//获取一个线程连接
            R  r = func.apply(t);
            System.out.println("r="+r);
            Thread.sleep(2000);
            return r;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(t != null) {
                pool.add(t); //用完要记得归还线程连接
            }
            semaphore.release();
        }
        return null;
    }

    public static void main(String[] args) {
        ObjPool<Long, String> objPool = new ObjPool<>(10,2L);
        for(int i=0;i<20;i++) {
            new Thread(()->{
                String result = objPool.execute(t -> {
                    return t.toString();
                });
            }).start();
        }
    }
}
