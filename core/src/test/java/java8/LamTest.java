package java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LamTest {

    @Test
    public void testOptional() {
        Map<String, Object> map = new HashMap<>();
        map.put("amount", "1");

        Optional<Map<String, Object>> optional = Optional.ofNullable(map);

        // 原始方法
//        Integer i = null;
//        Object o = map.get("amount");
//        if(o != null) {
//            String s = o.toString();
//            if(s != null) {
//                i = Integer.parseInt(s);
//            }
//        }

        // 使用Optional
        // 方法引用,就是把方法当做一个引用,作为参数,结果或赋值
        // 类::静态方法, 调用对象作为静态参数  `Integer::parseInt` 等价于 `s -> Integer.parseInt(s)` , 对象对象s作为parseInt参数
        // 类::实例方法, 第一个参数就是执行方法的对象 `Object::toString` 等价于 `o -> o.toString()`, 直接调用调用对象的toString方法
        // 构造方法
        Integer i = optional.map(k -> k.get("amount")).map(o -> o.toString()).map(s -> Integer.parseInt(s)).orElse(null);
        System.out.println(i);
    }

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
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(c -> c.toString(), c -> c));
        map.forEach((k, v) -> System.out.println("k : " + k + " , v : " + v));


        List<Map<String, Integer>> listMap = list.stream().map(i -> {
            Map<String, Integer> m =  new HashMap<>();
            m.put(i.toString(), i);
            return m;
        }).collect(Collectors.toList());
        listMap.forEach(l -> l.forEach((k, v) -> System.out.println("k : " + k + " , v : " + v)));
    }
}
