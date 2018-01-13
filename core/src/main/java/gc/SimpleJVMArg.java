package gc;

/**
 * Created by bin on 2017/12/17.
 */
public class SimpleJVMArg {
    /**
     * VM arg：-verbose:gc -Xms200M -Xmx200M -Xmn100M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution  -XX:+UseSerialGC
     *
     */
    // eden 80m     suerver 10m
    public static void main(String[] args)
    {
        final int tenMB = 10* 1024 * 1024;

        byte[] alloc1, alloc2, alloc3;

        alloc1 = new byte[tenMB / 5];   // eden分配2m
        alloc2 = new byte[5 * tenMB];   // eden分配50m

        System.out.println("第一次gc");
        alloc3 = new byte[4 * tenMB];   // 分配40m 不够了


        System.out.println("第二次gc");
        alloc3 = null;
        alloc3 = new byte[6 * tenMB];

    }

}
