package com.geek.concurrent.practice.practice06;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Allocator
 * @Description 使用等待-通知机制优化同步代码
 * @Author xuery
 * @Date 2019/4/20 11:28
 * @Version 1.0
 */
public class Allocator {

    private List<Object> als = new ArrayList<>();

    //申请所有的资源
    synchronized  void apply(Object from, Object to){
        //[注意点]如果这里是if则线程wait，被唤醒之后直接执行后面的语句，不会再判断条件是不是符合了
        while(als.contains(from) || als.contains(to)){
          try {
              wait();
          }catch (Exception e){
              e.printStackTrace();
          }
        }
        als.add(from);
        als.add(to);
    }

    //归还资源
    synchronized void free(Object from,Object to){
        als.remove(from);
        als.remove(to);
        notifyAll(); //尽量使用notifyAll，保证公平性
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
