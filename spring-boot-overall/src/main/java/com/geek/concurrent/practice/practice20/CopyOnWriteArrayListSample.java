package com.geek.concurrent.practice.practice20;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description TODO
 * Created by xuery on 2019/5/2.
 */
public class CopyOnWriteArrayListSample {

    public static void main(String[] args) {
        List<String>  list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if(next.equals("2")){
                iterator.remove();//CopyOnWrite不支持迭代器对元素增删改，因为它读取的只是一个快照
            }
        }
    }
}
