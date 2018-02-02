package gc;

public class OOMObj {
    private static final int _1MB = 1064 * 1064;


    private byte[] bytes;
    public OOMObj() {
            bytes = new byte[_1MB];
    }
}
