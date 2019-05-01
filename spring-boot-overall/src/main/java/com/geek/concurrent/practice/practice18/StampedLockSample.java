package com.geek.concurrent.practice.practice18;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @Description StampedLock 是 ReadWriteLock的升级版
 *
 * 支持三种模式：写锁、悲观读锁、乐观读（不加锁，类似于mysql的乐观读，读出来之后会做校验，检验通过则直接将数据返回）
 *
 * 注意点：
 * 1.
 * 2.
 *
 * Created by xuery on 2019/5/1.
 */
public class StampedLockSample {

    private final StampedLock sl = new StampedLock();

    public void readLock(){

        long stamp = sl.readLock();
        try{
            //todo 业务代码
        } finally {
            sl.unlockRead(stamp);
        }
    }

    public void writeLock(){
        long stamp = sl.writeLock();
        try{
            //todo 业务代码
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) throws Exception {
        final StampedLock lock = new StampedLock();
        Thread t1 = new Thread(()->{
            lock.writeLock();
            //阻塞在这里，不释放写锁
            LockSupport.park();
        });
        t1.start();
        Thread.sleep(100);

        Thread t2 = new Thread(()->{
            lock.readLock();
        });
        t2.start();
        Thread.sleep(100);
        t2.interrupt();
        t2.join();
    }

}
