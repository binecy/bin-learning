package com.springboot.start.redis;

public interface CacheService {

    void add(String key, String val);

    String get(String key);
}
