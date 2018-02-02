package base;

import org.junit.Test;

public class NumToBinary {
    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(-5));

        Integer i = new Integer(5);
        Integer j = new Integer(5);
        System.out.println(5 == i);
        System.out.println(i == j);
    }
}

