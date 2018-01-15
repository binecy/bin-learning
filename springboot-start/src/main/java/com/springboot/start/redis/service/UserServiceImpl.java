package com.springboot.start.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public void add(User user) {
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
    }

    @Override
    public User get(long id) {
        return redisTemplate.opsForValue().get(String.valueOf(id));
    }
}
