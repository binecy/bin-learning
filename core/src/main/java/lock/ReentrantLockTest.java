package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ExecutorService service = Executors.newFixedThreadPool(5);


        for(int i = 0; i < 30; i++) {
            service.execute(() -> {
                lock.lock();

                try {
                    System.out.println(Thread.currentThread().getName() + " start ");
                    Thread.currentThread().sleep(1000 * 3);

                    System.out.println(Thread.currentThread().getName() + " end ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
        }

    }
}
