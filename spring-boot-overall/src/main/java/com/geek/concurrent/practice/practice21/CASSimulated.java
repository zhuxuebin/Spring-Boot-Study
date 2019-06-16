package com.geek.concurrent.practice.practice21;

/**
 * @ClassName CASSimulated
 * @Description 模拟CAS操作
 * @Author xuery
 * @Date 2019/5/31 11:04
 * @Version 1.0
 */
public class CASSimulated {

    private volatile int count;

    //理解下
    public void addOne() {
        int newValue;
        int currValue;
        do {
            currValue = count;
            newValue = count + 1;
        } while (currValue != cas(currValue, newValue));

//        do {
//            newValue = count + 1;
//        } while (count != cas(count, newValue)); //todo xuery* 这样写有问题，count被两次读取，不能保证一样，前提是必须保证前后两个count值相等
    }

    //注意：这里只是模拟CAS，实际是通过底层CAS原子操作实现的
    public synchronized int cas(int expect, int newValue) {

        int currCount = count;
        if (currCount == expect) {
            count = newValue;
        }
        return currCount;
    }

    public static void main(String[] args) throws Exception{

        CASSimulated casSimulated = new CASSimulated();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                casSimulated.addOne();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                casSimulated.addOne();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(casSimulated.count);
    }
}
