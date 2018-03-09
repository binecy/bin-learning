package interrup;

/**
 * Created by liangguobin
 */
public class Base {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                    System.out.println("is interrupt : " + Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();

        Thread.currentThread().sleep(1000 * 1);
        t.interrupt();

    }
}
