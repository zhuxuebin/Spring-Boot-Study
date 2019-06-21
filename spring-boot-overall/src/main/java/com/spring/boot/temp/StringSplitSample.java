package com.spring.boot.temp;

/**
 * @ClassName StringSplitSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/20 9:36
 * @Version 1.0
 */
public class StringSplitSample {

    public static void main(String[] args) {
        String s = "sadas,sdas,";
        String[] sArr = s.split(",");
        for(String ss : sArr){
            System.out.println("==="+ss);
        }
    }
}
