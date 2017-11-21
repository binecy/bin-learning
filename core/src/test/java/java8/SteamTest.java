package java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SteamTest {

    @Test
    public void testStream() {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        list  = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        // 对象::实例方法
        list.forEach(System.out ::println);
    }

    @Test
    public void testStreamToMap() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }



        // 注意: Collectors.toMap方法,如果key有重复,会抛出异常
        // list.add(1);
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(c -> c.toString(), c -> c));
        map.forEach((k, v) -> System.out.println("k : " + k + " , v : " + v));


        List<Map<String, Integer>> listMap = list.stream().map(i -> {
            Map<String, Integer> m =  new HashMap<>();
            m.put(i.toString(), i);
            return m;
        }).collect(Collectors.toList());
        listMap.forEach(l -> l.forEach((k, v) -> System.out.println("k : " + k + " , v : " + v)));

        Comparator<Integer> c = (t1, t2) ->  Integer.compare(t1, t2);
//        Comparator<Integer> c = Integer::compare;


        Arrays.sort(new Integer[]{2,8,3,5,8}, c);
    }

    @Test
    public void testStreamGroup() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);



        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(Integer::intValue));

        map.forEach((k, vList)  -> {
            System.out.println(k  + " : " + vList.size());
        });


        Map<Boolean, List<Integer>> oddMap = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        oddMap.forEach((k, vList)  -> {
            System.out.println(k  + " : " + vList.size());
        });


        Map<Integer, Long> oddSum = list.stream().collect(Collectors.groupingBy(Integer::intValue , Collectors.counting()));
        oddSum.forEach((k, s)  -> {
            System.out.println(k  + " : " + s);
        });

        // parallelStream并行Steam, 注意线程安全问题
        Map<Integer, Long> oddSum2 = list.parallelStream().collect(Collectors.groupingBy(Integer::intValue , Collectors.counting()));
        oddSum2.forEach((k, s)  -> {
            System.out.println(k  + " : " + s);
        });


        //原始类型stream
//        IntStream.of(new int[]{1, 2, 3, 4});



    }
}
