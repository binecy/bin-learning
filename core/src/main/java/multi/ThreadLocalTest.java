package multi;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t = Thread.currentThread();

        ThreadLocal<Object> local = new ThreadLocal<Object>() {
            protected void finalize() throws Throwable {
                System.out.println(this.toString() + " threadLocal is gc");
            }
        };

        Object reference = new Object() {
            protected void finalize() throws Throwable {
                System.out.println(this.toString() + " object is gc");
            }
        };

        local.set(reference);

//        local.get();

        // 去掉强引用
        reference = null;
        local.set(null);
        local = null;

        System.gc();

        Thread.currentThread().sleep(1000);
        System.out.println("gc finish!!");

//        System.out.println(t);

    }

}
