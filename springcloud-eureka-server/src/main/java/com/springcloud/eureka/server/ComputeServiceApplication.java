package com.springcloud.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by bin.liang on 2017/2/16.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {



        public static void main(String[] args) {
            new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
        }

}
