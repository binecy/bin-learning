package gc;

import java.util.ArrayList;
import java.util.List;

public class OOMHelp {
    private static final int _1MB = 1064 * 1064;

    public static void oom() {
        List<OOMObj> list = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            list.add(new OOMObj());
    }
}
