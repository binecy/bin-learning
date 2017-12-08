package pattern;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class FactoryTest {

    @Test
    public void test() {
        // 简单工厂  生成具体类
        Instant instant = Instant.now();
        Date.from(instant);



        // 工厂方法 由实现类返回一个具体类
        // java.lang.Object#toString()
        // java.lang.Class#newInstance()
        // java.lang.Proxy#newProxyInstance()


        // 抽象工厂



        //建造模式
        //java.lang.StringBuilder#append()
        //java.lang.StringBuffer#append()

    }
}
