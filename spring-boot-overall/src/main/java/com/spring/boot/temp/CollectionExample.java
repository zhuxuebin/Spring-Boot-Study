package com.spring.boot.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CollectionExample
 * @Description TODO
 * @Author xuery
 * @Date 2019/5/22 17:51
 * @Version 1.0
 */
public class CollectionExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for(String s : list){
            System.out.println(s);
        }

        List<String> list2 = new ArrayList<>();
        list2.addAll(list.stream().filter(ll->ll.equals("1")).collect(Collectors.toList()));

        System.out.println(list2);
    }
}
