package com.dis.lock.redis;

import com.dis.lock.DisLockFactory;
import com.dis.lock.Work;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedissonLockTest {

    @Test
    public void test() {
        DisLockFactory factory = RedissonLockFactory.simpleFactory();

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
