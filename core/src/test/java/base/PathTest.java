package base;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bin on 2017/11/13.
 */
public class PathTest {

    @Test
    public void testGetResource() {
        //path不以’/'开头时，默认是从此类所在的包下取资源；
        //path  以’/'开头时，则是从ClassPath根下获取；
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/local.properties"));
        System.out.println(this.getClass().getResource("/xml/local.xml"));

        System.out.println(this.getClass().getResource("/base"));
        System.out.println(this.getClass().getResource("/base/simple"));


        System.out.println(this.getClass().getResource(""));
        System.out.println(this.getClass().getResource("simple"));

        //path不能以’/'开头时；
        //path是从ClassPath根下获取；
        System.out.println("-----------------");
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(this.getClass().getClassLoader().getResource("local.properties"));
        System.out.println(this.getClass().getClassLoader().getResource("xml/local.xml"));
        System.out.println(this.getClass().getClassLoader().getResource("base"));
        System.out.println(this.getClass().getClassLoader().getResource("base/simple"));


    }



}
