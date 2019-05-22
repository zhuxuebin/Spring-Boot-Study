package com.geek.concurrent.practice.practice15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName BlockQueue
 * @Description 利用lock+condition自己实现一个阻塞队列
 * @Author xuery
 * @Date 2019/4/30 11:02
 * @Version 1.0
 */
public class BlockQueue<T> {

    private final Lock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    int size = 2;

    private List<T> list = new ArrayList<>();

    /**
     * 入队列
     * @param t
     */
    public void enque(T t){
        try {
            lock.lock();
            //条件变量1
            while(list.size() == size){
                notFull.await(); //队列已满，等待队列不满
            }
            notEmpty.signal();
            list.add(t);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    /**
     * 出队列
     * @return
     */
    public T deque(){
        try{
            lock.lock();
            //条件变量2
            while(list.size() == 0){
                notEmpty.await();
            }
            T value = list.remove(0);
            notFull.signal();
            return value;
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

}
