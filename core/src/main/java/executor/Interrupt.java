package executor;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (true){
                    System.out.println(i++);
                }
            }
        });

        t.start();

        Thread.currentThread().sleep(1000);
        t.interrupt();
    }
}
