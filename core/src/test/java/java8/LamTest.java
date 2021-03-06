package java8;

import org.junit.Test;

import java.util.*;

public class LamTest {

    @Test
    public void testRun() {
        new Thread(() -> {
            System.out.println("hello, lambda");
        }).start();
    }

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
        // 类::静态方法, 调用对象作为静态参数  `Integer::parseInt` 等价于 `s -> Integer.parseInt(s)` , 对象对象s作为parseInt参数
        // 类::实例方法, 第一个参数就是执行方法的对象 `Object::toString` 等价于 `o -> o.toString()`, 直接调用调用对象o的toString方法
        // 构造方法
        Integer i = optional.map(k -> k.get("amount")).map(o -> o.toString()).map(s -> Integer.parseInt(s)).orElse(null);
        System.out.println(i);


    }

}
