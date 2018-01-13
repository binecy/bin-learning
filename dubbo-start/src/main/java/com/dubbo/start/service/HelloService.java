package com.dubbo.start.service;


import javax.validation.constraints.NotNull;

/**
 * Created by bin on 2017/2/28.
 */
public interface HelloService {
    String hello(@NotNull String user) ;
    String hello2(String user) ;
}
