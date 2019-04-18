package com.geek.concurrent.practice.practice02;

/**
 * @ClassName VolatileExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/18 14:46
 * @Version 1.0
 */
public class VolatileExample {

    int x = 0;
    volatile  boolean v = false;

    public void writer(){
        x = 42;
        v = true;
    }

    public void reader(){
        if(v){
            //一定是42
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws Exception{

        VolatileExample volatileExample = new VolatileExample();

        Thread t1 = new Thread(()->{
            volatileExample.reader();
        });

        Thread t2 = new Thread(()->{
            volatileExample.writer();
        });

        t2.start();
        t1.start();

        t1.join();
        t2.join();
    }

}
