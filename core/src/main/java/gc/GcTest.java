package gc;

/**
 * -Xmx20m -Xms20m -Xmn10m -XX:+UseParNewGC  -XX:+UseConcMarkSweepGC
 * -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=75
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC
 */
public class GcTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] b1 = new byte[2 * _1MB];
        byte[] b2 = new byte[2 * _1MB];
        byte[] b3 = new byte[2 * _1MB];
        byte[] b4 = new byte[4 * _1MB];

        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        b4 = new byte[4 * _1MB];

        System.gc();
        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        b4 = new byte[4 * _1MB];
    }
}
