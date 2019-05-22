package com.spring.boot.temp;

/**
 * @ClassName StringFormatSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/21 10:33
 * @Version 1.0
 */
public class StringFormatSample {

    public static void main(String[] args) {
        String templateStr = "hello %s, I am %s,would you like to associate with me";
        System.out.println(String.format(templateStr, "czh","zzz"));

        new Thread(()->{

        });

    }
}
