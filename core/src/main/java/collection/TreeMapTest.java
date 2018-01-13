package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
//        Map<Integer, String> map = new TreeMap<>();
//        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new LinkedHashMap<>();


        map.put(1, "a");
        map.put(4, "d");
        map.put(3, "c");
        map.put(5, "f");
        map.put(2, "b");
        map.put(2, "b");
        map.put(2, "b");



        map.forEach((k, v) -> {
            System.out.println(k  + " : " + v);
        });
    }
}
