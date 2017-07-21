package com.disconf.start;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by liangguobin on 2017/7/13.
 */
@Service
@Scope("singleton")
public class SimpleRedisService implements InitializingBean, DisposableBean {



    // jedis 实例
    private Jedis jedis = null;

    /**
     * 分布式配置
     */
    @Autowired
    private JedisConfig jedisConfig;

    /**
     * 关闭
     */
    @Override
    public void destroy() throws Exception {

        if (jedis != null) {
            jedis.disconnect();
        }
    }

    /**
     * 进行连接
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), jedisConfig.getHost());    // host为redis ip
        jedis = pool.getResource();
    }

    /**
     * 获取一个值
     *
     * @param key
     * @return
     */
    public String getKey(String key) {
        if (jedis != null) {
            return jedis.get(key);
        }

        return null;
    }
}
