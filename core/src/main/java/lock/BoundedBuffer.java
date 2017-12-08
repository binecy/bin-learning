package lock;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer<T> {

    private Condition notFull;
    private Condition notEmpty;

    private Lock lock;

    private Deque<T> deque;

    private int cap = 10;

    public BoundedBuffer() {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();

        deque = new ArrayDeque<>(cap);
    }

    public void push(T t) throws InterruptedException {
        lock.lock();

        try {
            while (deque.size() >= cap) {
                System.out.println("notFull.await() ...");
                notFull.await();
            }

            deque.push(t);

            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();

        T t;
        try {
            while (deque.isEmpty()) {
                System.out.println("notEmpty.await() ...");
                notEmpty.await();
            }

            t = deque.pop();

            notFull.signal();
        } finally {
            lock.unlock();
        }

        return t;

    }

    public static void main(String[] args) {
        BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);




        executorService.execute(() -> {
            try {
                while(true) {
                    System.out.println("pop : " + boundedBuffer.pop());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ExecutorService executorService2 = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 30; i++) {
            int finalI = i;
            executorService2.execute(() -> {
                for(int j = 0; j < 30; j++) {
                    try {
                        boundedBuffer.push(j);
                        System.out.println("push : " + finalI + " - " + j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

        }

    }
}
