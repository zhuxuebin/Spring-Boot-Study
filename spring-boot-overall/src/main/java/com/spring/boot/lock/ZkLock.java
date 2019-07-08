package com.spring.boot.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * https://blog.csdn.net/lovexiaotaozi/article/details/83382128
 * Created by xuery on 2019/6/22.
 */
@Slf4j
public class ZkLock {

    public boolean lock(String lockpath) {
        InterProcessLock lock = new InterProcessMutex(ZkClientUtil.build(), lockpath);
        try {
            if (lock.acquire(10, TimeUnit.SECONDS)) {
                return true;
            }
        } catch (Exception e) {
            log.error("ZkLock.lock.error", e);
        }
        return false;
    }

    public void unlock(String lockpath) {
        InterProcessLock lock = new InterProcessMutex(ZkClientUtil.build(), lockpath);
        try {
            lock.release();
        } catch (Exception e) {
            log.error("ZkLock.lock.release.error", e);
        }
    }
}
