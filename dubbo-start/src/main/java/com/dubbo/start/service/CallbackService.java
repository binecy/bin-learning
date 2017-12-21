package com.dubbo.start.service;

public interface CallbackService {

    void addListener(String key, CallbackListener listener);
}
