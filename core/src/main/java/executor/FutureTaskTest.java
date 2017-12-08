package executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, NoSuchFieldException {

//        FutureTask task = new FutureTask(() -> {
//            System.out.println("run start");
//            try {
//                Thread.currentThread().sleep(1000 * 3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("run end");
//        }, 0);

        FutureTask task = new FutureTask(() -> {
            System.out.println("run start");
            try {
                Thread.currentThread().sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end");
            return 1;
        });


        System.out.println("task run ...");
        task.run();


        System.out.println("task get : " + task.get());



    }
}
