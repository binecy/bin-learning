package collection;

import java.sql.Time;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * java延迟任务
 */
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedTask> queue = new DelayQueue();


        long cur = System.currentTimeMillis();

        queue.add(new DelayedTask(cur + 100, "a"));
        queue.add(new DelayedTask(cur + 900, "d"));
        queue.add(new DelayedTask(cur + 600, "c"));
        queue.add(new DelayedTask(cur + 300, "b"));

        while(!queue.isEmpty()) {
            System.out.println(queue.take());
        }

    }
}


class DelayedTask implements Delayed {
    private long expiryTime;
    private String name;

    DelayedTask(long expiryTime, String name) {
        this.expiryTime = expiryTime;
        this.name = name;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "time : " + System.currentTimeMillis() + " , task : " + name;
    }
}
