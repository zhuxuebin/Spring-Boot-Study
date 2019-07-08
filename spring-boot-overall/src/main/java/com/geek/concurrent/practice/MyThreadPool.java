package com.geek.concurrent.practice;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description 自己实现一个固定大小的线程池
 * Created by xuery on 2019/7/8.
 */
public class MyThreadPool {

    private int threads;

    private List<Thread> threadList;

    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int threads, int cap){
        this.threads = threads;
        this.threadList = new ArrayList<>(threads);
        queue = new ArrayBlockingQueue<>(cap);
    }

    public void init(){
        for(int i=0;i<threads;i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"myThreads-"+i);
            t.start();
            threadList.add(t);
        }

    }

    //实现有返回值的线程池，将实现Callable的MyTask包装成FutureTask
    public String execute(MyTask myTask){
        try {
            FutureTask<String> futureTask = new FutureTask<>(myTask);
            queue.put(futureTask);
            return futureTask.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static class MyTask implements Callable{
        private int index;

        public MyTask(int index){
            this.index = index;
        }

        @Override
        public Object call(){
            System.out.println(Thread.currentThread().getName()+" myTask.run..."+index);
            return "task-"+index+" execute task...";
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5,100);
        pool.init();
        for(int i=0;i<100;i++) {
           String ret = pool.execute(new MyTask(i));
            System.out.println("res..."+ret);
        }
    }
}
