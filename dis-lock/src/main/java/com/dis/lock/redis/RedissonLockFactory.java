package com.dis.lock.redis;

import com.dis.lock.DisLock;
import com.dis.lock.DisLockFactory;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonLockFactory implements DisLockFactory {
    private RedissonClient client;
    public RedissonLockFactory(Config config) {
        client = Redisson.create(config);
    }

    public static RedissonLockFactory simpleFactory() {
        Config config = new Config();
        config.useSingleServer().setAddress("http://127.0.0.1:6379").setDatabase(0);
        return new RedissonLockFactory(config);
    }


    @Override
    public DisLock getLock(String lockName) {
        return new RedissonLock(client.getLock(lockName));
    }
}
