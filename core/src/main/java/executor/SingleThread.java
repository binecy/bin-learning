package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {


    public static void main(String[] args) {
        // 简单工厂
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++){
            executorService.execute(() ->{

                System.out.println(Thread.currentThread().getName() + " start ");
                try {
                    Thread.currentThread().sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end ");
            });

        }
        executorService.shutdown();
    }
}
