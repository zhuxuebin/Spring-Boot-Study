package com.spring.boot.temp;

import java.util.*;

/**
 * @ClassName IteratorSample
 * @Description TODO
 * @Author xuery
 * @Date 2019/6/20 17:44
 * @Version 1.0
 */
public class IteratorSample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("1","4","3"));

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String next = it.next();
            if(next.equals("1")) {
                it.remove();
            }
        }
        System.out.println(list);


        Set<String> set = new HashSet<>(Arrays.asList("1","2","3"));

        set.addAll(list);

        System.out.println(set);
    }
}
