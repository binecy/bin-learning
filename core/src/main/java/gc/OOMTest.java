package gc;

public class OOMTest {
    private static final int _1MB = 1064 * 1064;

    /**
     * vm参数： -Xms60M -Xmx60M -Xmn10M -XX:+PrintGCDetails  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/binecy/work/dump
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {


        byte[] allocation1, allocation2, allocation3, allocation4, allocation5,
                allocation6, allocation7;

        allocation1 = new byte[4 * _1MB];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];


        allocation4 = new byte[6 * _1MB];
        allocation5 = new byte[6 * _1MB];
        allocation6 = new byte[6 * _1MB];

        allocation7 = new byte[6 * _1MB];

//        Thread.currentThread().sleep(1000 * 300);

    }
}
