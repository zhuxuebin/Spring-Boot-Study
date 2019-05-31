package com.geek.concurrent.practice.practice23_26;

import org.apache.commons.lang3.ThreadUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompletableFutureSample03
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/31 15:11
 * @Version 1.0
 */
public class CompletableFutureSample03 {

    public static void main(String[] args) {

        //串行
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(s -> s + " QQ")
                .thenApply(String::toUpperCase);

        System.out.println(f0.join());

        //Or
        CompletableFuture<String> orf1 = CompletableFuture.supplyAsync(() -> {
            SleepUtils.sleep(1000);
            return "1";
        });
        CompletableFuture<String> orf2 = CompletableFuture.supplyAsync(() -> {
            SleepUtils.sleep(800);
            return "2";
        });
        CompletableFuture<String> orf = orf1.applyToEither(orf2, s -> s);

        System.out.println(orf.join());

        //异常处理
        CompletableFuture<Integer> exceptionf = CompletableFuture.supplyAsync(()->7/0)
                .thenApply(r->10*r)
                .exceptionally(e->0);
        System.out.println(exceptionf.join());
    }
}
