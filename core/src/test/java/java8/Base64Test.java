package java8;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Test {

    @Test
    public void test() {
        Base64.Encoder encoder = Base64.getEncoder();
        String original = "bin" + ":" + "9108";
        String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));

        System.out.println(encoded);

        Base64.Decoder decoder = Base64.getDecoder();
        String decoded  = new String(decoder.decode(encoded));
        System.out.println(decoded);

    }
}
