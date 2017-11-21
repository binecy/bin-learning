package com.dis.lock.redis;

import com.dis.lock.DisLock;
import org.redisson.api.RLock;


import java.util.concurrent.TimeUnit;

public class RedissonLock implements DisLock {

    private RLock lock;

    protected RedissonLock(RLock lock) {
        this.lock = lock;
    }

    @Override
    public boolean tryLock(int timeSecond) throws InterruptedException {
        return lock.tryLock(timeSecond, TimeUnit.SECONDS);
    }

    @Override
    public void unLock() {
        lock.unlock();
    }
}
