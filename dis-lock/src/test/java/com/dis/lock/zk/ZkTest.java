package com.dis.lock.zk;

import com.dis.lock.DisLockFactory;
import com.dis.lock.Work;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZkTest {

    @Test
    public void test() throws IOException {
        DisLockFactory factory = ZkLockFactory.simpleFactory();

        ExecutorService service = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++) {
            service.execute(new Work(factory.getLock("anyLock")));
        }

        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
