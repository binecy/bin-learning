package com.springboot.start.redis.service;

public interface CacheService {

    void add(String key, String val);

    String get(String key);
}
