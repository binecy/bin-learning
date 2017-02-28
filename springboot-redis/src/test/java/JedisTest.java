import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by bin on 2017/2/28.
 */
public class JedisTest {
    @Test
    public void test() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "52.37.134.248");    // host为redis ip


        try (Jedis jedis = pool.getResource()) {
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            Assert.assertEquals(foobar, "bar");
        }
    }
}
