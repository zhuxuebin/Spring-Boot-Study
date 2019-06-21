package com.spring.boot.temp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ArrayListLinkedListSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/20 17:27
 * @Version 1.0
 */
public class ArrayListLinkedListSample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        long t1 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            list.add(i);
        }

        long t2 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<1000000;i++){
            linkedList.add(i);
        }
        long t3 = System.currentTimeMillis();

        System.out.println(t2-t1);
        System.out.println(t3-t2);
    }
}
