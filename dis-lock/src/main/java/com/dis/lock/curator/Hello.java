package com.dis.lock.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

public class Hello {
    public static void main(String[] args) throws Exception {
        String address = "aws.binecy.com:2181";

        CuratorFramework client = CuratorFrameworkFactory.newClient(address, new ExponentialBackoffRetry(1000, 3));

        try {
            client.start();

//            client.create()
//                    .creatingParentContainersIfNeeded()
//                    .withMode(CreateMode.PERSISTENT)
//                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
//                    .forPath("/curator", "hello, zk".getBytes());

            InterProcessMutex lock = new InterProcessMutex(client, "/curator");

            lock.acquire();


            System.out.println("start...");
            Thread.sleep(1000);
            System.out.println("end...");

            lock.release();
        } finally {
            client.close();
        }

    }
}
