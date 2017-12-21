package com.springboot.start.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void add(String key, String val) {
        stringRedisTemplate.opsForValue().set(key, val);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
