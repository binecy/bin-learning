package com.dis.lock.curator;

import com.dis.lock.DisLock;
import com.dis.lock.DisLockFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;


public class CuratorLockFactory implements DisLockFactory {
    public static CuratorLockFactory simpleFactory() {
        String address = "aws.binecy.com:2181";

        CuratorFramework client = CuratorFrameworkFactory.newClient(address, new ExponentialBackoffRetry(1000, 3));
        client.start();
        return new CuratorLockFactory(client);
    }

    private CuratorFramework client;
    public CuratorLockFactory(CuratorFramework client) {
        this.client = client;
    }


    @Override
    public DisLock getLock(String lockName) {
        return new CuratorLock(new InterProcessMutex(client, lockName));
    }
}
