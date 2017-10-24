package com.dis.lock.zk;

import com.dis.lock.DisLock;
import com.dis.lock.DisLockFactory;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZkLockFactory implements DisLockFactory{
    private ZooKeeper zk;

    public static ZkLockFactory simpleFactory() throws IOException {
        return new ZkLockFactory(new ZooKeeper("127.0.0.1:2181", 10000, null));
    }

    public ZkLockFactory(ZooKeeper zk) {
        this.zk = zk;
    }


    @Override
    public DisLock getLock(String lockName)  {
        try {
            return new ZkLock(zk, "/lock/" + lockName);
        } catch (Exception e) {
            throw new RuntimeException("create lock fail", e);
        }
    }
}
