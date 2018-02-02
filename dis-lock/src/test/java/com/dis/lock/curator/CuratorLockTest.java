package com.dis.lock.curator;

import com.dis.lock.DisLockFactory;
import com.dis.lock.Work;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CuratorLockTest {

    @Test
    public void test() {
        DisLockFactory factory = CuratorLockFactory.simpleFactory();

        ExecutorService service = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++) {
            service.execute(new Work(factory.getLock("/curator")));
        }

        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
