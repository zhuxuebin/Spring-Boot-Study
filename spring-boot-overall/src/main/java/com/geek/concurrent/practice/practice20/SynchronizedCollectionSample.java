package com.geek.concurrent.practice.practice20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * Created by xuery on 2019/5/2.
 */
public class SynchronizedCollectionSample {

    public static void main(String[] args) throws Exception{
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("1");
        list.add("2");

        //对于List的遍历操作需要用户自己去保证安全性
        new Thread(()->{
            Iterator<String> iter = list.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            list.add("3"); //迭代器遍历时，如果中途对list的添加元素，会ConcurrentModificationException
        }).start();

    }
}
