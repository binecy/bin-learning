package com.dis.lock;



public interface DisLockFactory {
    DisLock getLock(String lockName) ;
}
