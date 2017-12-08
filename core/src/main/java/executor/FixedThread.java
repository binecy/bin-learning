package executor;

import java.util.concurrent.*;

public class FixedThread {
    public static void main(String[] args) {
        // 简单工厂
        ExecutorService executorService = new ThreadPoolExecutor(1, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 5; i++){
            executorService.execute(() ->{

                System.out.println(Thread.currentThread().getName() + " start ");
                try {
                    Thread.currentThread().sleep(1000 * 30000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Long t = null;
                System.out.println(t.intValue());
                System.out.println(Thread.currentThread().getName() + " end ");
            });

        }
        executorService.shutdown();
    }
}
