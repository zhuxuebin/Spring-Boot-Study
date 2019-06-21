package com.spring.boot.temp;

/**
 * @ClassName StringEqualSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/20 16:27
 * @Version 1.0
 */
public class StringEqualSample {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
