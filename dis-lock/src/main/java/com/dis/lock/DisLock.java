package com.dis.lock;

public interface DisLock {

    boolean tryLock(int timeSecond) throws InterruptedException;

    void unLock();
}
