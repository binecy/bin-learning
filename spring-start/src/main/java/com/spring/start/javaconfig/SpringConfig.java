package com.spring.start.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Piano piano() {
        return new Piano(12000, "666");
    }


}
