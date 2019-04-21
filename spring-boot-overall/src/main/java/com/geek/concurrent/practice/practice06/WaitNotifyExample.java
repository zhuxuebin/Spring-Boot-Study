package com.geek.concurrent.practice.practice06;

/**
 * @ClassName WaitNotifyExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/20 12:29
 * @Version 1.0
 */
public class WaitNotifyExample {


    int count = 0;

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();
        Thread t1 = new Thread(()->{
            example.consumer();
        });

        Thread t2 = new Thread(()->{
            example.producer();
        });

        t1.start();
        t2.start();
    }

    public void consumer(){
        try {
            while(true) {
                synchronized (this) {
                    System.out.println("consumer-begin-count="+count);
                    while (count <= 100) {
                        wait();//wait会释放锁，之后被notify之后要重新去拿锁才能被唤醒往下执行；拿到锁之后并不会执行上面的sout
                    }
                    count--;
                    System.out.println("consumer:" + count);
                }
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void producer(){

        try {
            while(true) {
                synchronized (this) {
                    System.out.println("producer-begin-count="+count);
                    while (count >= 10) {
                        wait();
                    }
                    count++;
                    System.out.println("producer:" + count);
                    notify();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
