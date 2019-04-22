package com.geek.concurrent.practice.practice09;

/**
 * @ClassName DeadLockSample
 * @Description 模拟循环等待死锁
 * @Author xuery
 * @Date 2019/4/22 10:31
 * @Version 1.0
 */
public class DeadLockSample {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public static void main(String[] args) {

        DeadLockSample sample = new DeadLockSample();

        Thread t1 = new Thread(()->{
            sample.method1();
        });
        Thread t2 = new Thread(()->{
            sample.method2();
        });

        t1.start();
        t2.start();
    }

    public void method1(){

        try {
            synchronized (lock1) {
                Thread.sleep(1000);
                synchronized (lock2) {
                    System.out.println("method1");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void method2(){

        try {
            synchronized (lock2) {
                Thread.sleep(1000);
                synchronized (lock1) {
                    System.out.println("method2");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
