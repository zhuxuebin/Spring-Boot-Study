package com.geek.concurrent.practice.practice01;

/**
 * @ClassName Test
 * @Description 可见性测试
 * @Author xuery
 * @Date 2019/4/17 20:53
 * @Version 1.0
 */
public class Test {

    private long count = 0;

    private void add10k(){
        int idx = 0;
        while(idx++ < 100000000){
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t1 = new Thread(()->{
            test.add10k();
        });

        Thread t2 = new Thread(()->{
            test.add10k();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(test.count);
    }
}
