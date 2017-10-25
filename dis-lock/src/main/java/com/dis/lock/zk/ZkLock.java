package com.dis.lock.zk;

import com.dis.lock.DisLock;
import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZkLock implements DisLock{
    private ZooKeeper zk;

    private String lockPath;

    private String lockedNode;

    protected ZkLock(ZooKeeper zk, String lockPath) throws KeeperException, InterruptedException {
        this.zk = zk;
        this.lockPath = lockPath;


        if(zk.exists(lockPath, false) == null) {
            try {
                zk.create(lockPath, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } catch (KeeperException ke) {
                if(ke.code() == KeeperException.Code.NODEEXISTS) {
                    System.out.println("node is exists");
                } else {
                    throw  ke;
                }
            }
        }
    }

    @Override
    public boolean tryLock(int timeSecond) throws InterruptedException {

        String path = null;
        try {
            // 创建一个临时顺序节点
            path = zk.create(lockPath + "/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            // 节点名
            String lockNode = path.substring(lockPath.length() + 1);

            return acquireLock(lockNode, timeSecond, null);
        } catch (KeeperException e) {
            e.printStackTrace();

            if(path != null) {
                try {
                    zk.delete(path, -1);
                } catch (KeeperException e1) {
                }
            }
        }

        return false;
    }

    private boolean acquireLock(String lockNode, int timeSecond, CountDownLatch existLatch) throws InterruptedException, KeeperException {
        // 获取所以的子节点,就是所以的加锁节点
        List<String> allLock = null;

            allLock = zk.getChildren(lockPath, false);

        // 排序
        Collections.sort(allLock);
        // 当前请求锁的位置
        int lockIndex = allLock.indexOf(lockNode);


        if(lockIndex < 0) {
            // 出错了
            return false;
        } else if(lockIndex == 0) {     // 当前请求锁节点在第一位, 加锁成功

            lockedNode = lockNode;
            return true;
        } else {    // 当前请求锁节点不在第一位
            if(timeSecond <= 0) {
                return false;
            }

            // 获取前一个节点
            String preLock = allLock.get(lockIndex - 1);

            // CountDownLatch用于阻塞当前线程, 以等待锁
            // 第一次监听时,要创建CountDownLatch, 再次监听时, 会传递CountDownLatch参数
            CountDownLatch newLatch = null;
            if(existLatch == null) {
                newLatch = new CountDownLatch(1);
                existLatch = newLatch;
            }

            // 监听前一个节点, 如果前一个节点发生变化(如删除), 当前节点重新获取锁
            watchPath(lockPath + "/" + preLock, lockNode, timeSecond, existLatch);


            return newLatch == null ? false : newLatch.await(timeSecond, TimeUnit.SECONDS);
        }
    }

    private void watchPath(String path, String lockNode, int time, CountDownLatch latch) throws InterruptedException, KeeperException {

            zk.exists(path, new Watcher() {
                public void process(WatchedEvent event) {
                    try {
                        // 获取锁成功
                        if(acquireLock(lockNode, time, latch)) {
                            // 继续进行线程
                            latch.countDown();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

    }

    @Override
    public void unLock() {
        try {
            zk.delete(lockPath + "/" + lockedNode, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
