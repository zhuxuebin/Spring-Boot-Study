package com.geek.concurrent.practice.practice23_26;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompletableFutureSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 14:48
 * @Version 1.0
 */
public class CompletableFutureSample {

    public static void main(String[] args) {

        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(()->{
            System.out.println("T1 烧开水");
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println("T2 洗茶壶");
            return "龙井茶";
        });

        //T1.T2执行完之后执行T3：泡茶
        CompletableFuture<String> cf3 = cf1.thenCombine(cf2,(__,cf)->{
            //cf是thenCombine里面cf2的返回结果, __代表cf1返回void
            System.out.println("泡茶："+cf);
            return "上茶"+cf;
        });

        System.out.println(cf3.join());
    }
}
