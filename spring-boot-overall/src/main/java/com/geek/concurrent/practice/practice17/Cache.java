package com.geek.concurrent.practice.practice17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 利用ReadWriteLock实现一个简易本地缓存
 *
 * 读锁共享，读写锁互斥，写写锁互斥
 *
 * 读锁不能升级为写锁：就是读锁释放前，不能先升级为写锁，再释放读锁
 * --好理解，升级为写锁，只要其他线程存在读锁，则无法立刻获取写锁，可能导致死锁
 *
 * 写锁可以降级为读锁：写锁释放之前，先获取读锁，再释放写锁
 * --好理解，写锁获取到了，说明其他线程没有获取到读锁或者写锁，本线程可以立刻获得读锁
 * Created by xuery on 2019/5/1.
 */
public class Cache<K,V> {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    Map<K,V> map = new HashMap<>();

    V get(K key){
        try{
            readLock.lock();
            return map.get(key);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    void put(K key, V value){
        try{
            writeLock.lock();
            map.put(key,value);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
