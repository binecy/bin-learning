package gc;

/**
 * Created by bin on 2017/12/17.
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    // JVM Args:
    // -XX:+PrintGCDetails
    // -XX:+UseSerialGC
    // -Xms20m -Xmx20m
    // -Xmn10m -XX:SurvivorRatio=8
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===1. start full gc start===");
        System.gc();
        System.out.println("===1. start full gc end===\n");

        System.out.println("===2. gc logs===");
        byte[] a1 = new byte[_1MB / 4];
        byte[] a2 = new byte[4 * _1MB];
        byte[] a3 = new byte[4 * _1MB];// 一次Minor GC
        byte[] a4 = new byte[4 * _1MB];// 一次Minor GC
        byte[] a5 = new byte[4 * _1MB];// 一次Minor GC + 一次Full GC ⇒ OOM
    }
}
