package com.dis.lock;



public interface DisLockFactory {
    /**
     * 生成一个锁
     * @param lockName
     * @return
     */
    DisLock getLock(String lockName) ;
}
