package multi;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t = Thread.currentThread();

        ThreadLocal<Object> local = new ThreadLocal<>();

        Object reference = new Object();

        local.set(reference);

        local.get();

        // 去掉强引用
        local = null;
        reference = null;
        System.gc();

        System.out.println(t);


    }

}
