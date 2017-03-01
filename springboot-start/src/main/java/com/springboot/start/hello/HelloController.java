package com.springboot.start.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bin on 2017/2/26.
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String index() {
        return "Hello World";
    }
}
