package com.dis.lock;

public interface DisLock {

    /**
     * 申请加锁
     * @param timeSecond    最长等待时间 超时直接返回false
     * @return
     * @throws InterruptedException
     */
    boolean tryLock(int timeSecond) throws InterruptedException;

    /**
     * 释放锁
     */
    void unLock();
}
