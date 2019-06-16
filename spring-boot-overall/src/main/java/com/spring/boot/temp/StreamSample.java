package com.spring.boot.temp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName StreamSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/27 17:39
 * @Version 1.0
 */
public class StreamSample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

//        list.add("1");
//        list.add("2");
//        list.add("3");
//        String sL = list.stream().filter(s->s.equals("4")).findFirst().get();
//        System.out.println(sL);

        Set<String> set = new HashSet<>();
        System.out.println(set.contains("1"));
    }
}
