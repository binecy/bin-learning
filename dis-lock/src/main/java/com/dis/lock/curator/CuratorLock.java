package com.dis.lock.curator;

import com.dis.lock.DisLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

public class CuratorLock implements DisLock {

    private InterProcessMutex lock;


    public CuratorLock(InterProcessMutex lock) {
        this.lock = lock;
    }

    @Override
    public boolean tryLock(int timeSecond) throws InterruptedException {
        try {
            return lock.acquire(timeSecond, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void unLock() {
        try {
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
