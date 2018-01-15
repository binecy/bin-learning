package com.springboot.start.redis.service;

public interface UserService {
    void add(User val);

    User get(long id);
}
