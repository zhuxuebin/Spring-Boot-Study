package com.geek.concurrent.practice.practice09;

/**
 * @ClassName InterruptedSample01
 * @Description 本意是要实现线程t1接收到中断后跳出while循环
 * @Author xuery
 * @Date 2019/4/22 11:08
 * @Version 1.0
 */
public class InterruptedSample01 {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            Thread thread = Thread.currentThread();
            while (true){
                //【2】thread.isInterrupted()不会重置中断标志，Thread.interrupted则调用完之后会重置中断标志
                if(thread.isInterrupted()){
                    break;
                }

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt(); //【1】抛出异常会重置中断标志，所以这里需要重新中断下
                    e.printStackTrace();
                }
            }
            System.out.println("break");
            if(thread.isInterrupted()){
                System.out.println("isInterrupted="+thread.isInterrupted());
            }
            if(Thread.interrupted()){
                System.out.println("interrupted="+Thread.interrupted());
            }
        });

        Thread t2 = new Thread(()->{
            t1.interrupt();
        });

        t1.start();
        t2.start();
    }
}
