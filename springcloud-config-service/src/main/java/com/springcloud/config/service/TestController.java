package com.springcloud.config.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bin on 2017/3/6.
 */
@RefreshScope
@RestController
class TestController {
    @Value("${from}")
    private String from;

    //  访问http://localhost:7002/from
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }


    //  curl -d "" http://localhost:7002/refresh  刷新配置
}