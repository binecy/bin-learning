package com.springcloud.zuul;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by bin.liang on 2017/2/17.
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
        // 访问http://localhost:5555/api-a/add?a=1&b=2&accessToken=token即可
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
