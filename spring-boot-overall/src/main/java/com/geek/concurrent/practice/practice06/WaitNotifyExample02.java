package com.geek.concurrent.practice.practice06;

/**
 * @ClassName WaitNotifyExample02
 * @Description
 * 验证两个点：
 * 1:
 * 1.1. wait之后是放入一个等待队列(2)
 * 1.2. wait对应的线程被唤醒后，放入竞争对应互斥锁的队列(1)，竞争到且条件满足才往下执行，
 *    反之没竞争（一直等待竞争到）到或者竞争到了条件不满足（重新放回等待队列(2)）不会往下执行
 *
 * 2:
 * notify/notifyAll/wait只能放在synchronized代码块内部且由当前互斥锁调用，不然会抛异常
 *
 * @Author xuery
 * @Date 2019/4/22 20:16
 * @Version 1.0
 */
public class WaitNotifyExample02 {

    boolean flag = false;

    boolean flag1 = false;

    private final Object lock = new Object();

    public static void main(String[] args) {
        WaitNotifyExample02 example02 = new WaitNotifyExample02();
        example02.method1();
    }

    public void method1(){
        Thread t1 = new Thread(()->{
            synchronized (lock) {
                try {
                    while (!flag) {
                        lock.wait();
                    }
                    while (flag1){
                        lock.wait();
                    }
                    System.out.println("t1");
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock) {
                try {
                    while (!flag1) {
                        lock.wait();
                    }
                    System.out.println("t2");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(()->{
            synchronized (lock){
                System.out.println("t3");
                try{
                    Thread.sleep(2000);
                    flag = true;
                    flag1 = true;
                    lock.notifyAll();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        

        t1.start();
        t2.start();
        t3.start();
    }
}
