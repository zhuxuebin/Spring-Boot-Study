package com.geek.concurrent.practice.practice05;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Allocator
 * @Description TODO
 * @Author xuery
 * @Date 2019/4/20 11:28
 * @Version 1.0
 */
public class Allocator {

    private List<Object> als = new ArrayList<>();

    //申请所有的资源
    synchronized  boolean apply(Object from, Object to){
        if(als.contains(from) || als.contains(to)){
            return false; //其他线程已经抢占了资源
        } else{
            als.add(from);
            als.add(to);
        }

        return true;
    }

    //归还资源
    synchronized void free(Object from,Object to){
        als.remove(from);
        als.remove(to);
    }

    //单例，通过使用内部类实现
    private Allocator(){}

    private static class InnerClass{
        private static Allocator allocator = new Allocator();
    }

    public static Allocator getInstance(){
        return InnerClass.allocator;
    }
}
