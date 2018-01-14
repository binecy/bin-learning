package gc;

/**
 * Created by bin on 2018/1/13.
 */
public class Cloader {
    private int j = 1;
    {
        j = 2;
    }

    private static int i = 1;
    static {
        i = 2;
    }



    public Cloader() {
        i = 3;
        j = 3;
    }

    public static void main(String[] args) {
        Cloader cloader = new Cloader();
        System.out.println(cloader.i);
        System.out.println(cloader.j);
    }
}
