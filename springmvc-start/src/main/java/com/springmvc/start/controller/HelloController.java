package com.springmvc.start.controller;

import com.springmvc.start.SimpleExceptionResolver;
import com.springmvc.start.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created by bin on 2018/1/13.
 * your-project$ gradle jettyRun
 * 访问http://localhost:9191/spring4/?name=bin
 * 参考：https://www.mkyong.com/spring-mvc/gradle-spring-mvc-web-project-example/
 * debug教程：https://chenkaihua.com/2016/02/20/idea-webapp-remote-debug-via-gretty/
 */
@Controller
public class HelloController {


    @Autowired
    SimpleExceptionResolver handlerExceptionResolver;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam(required = false) String name) {
        if(name == null) {
            throw new NullPointerException("name can not be null");
        }

        if("null".equals(name)) {
            throw new IllegalArgumentException("name can not be null");
        }

//        System.out.println("HandlerExceptionResolver : " + handlerExceptionResolver);


        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
        System.out.println("ApplicationContext : " + applicationContext);
        HandlerExceptionResolver handlerExceptionResolver2 = applicationContext.getBean("simpleExceptionResolver", HandlerExceptionResolver.class);
        System.out.println("HandlerExceptionResolver2 : " + handlerExceptionResolver2);
        return "hello, " + name;
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleIOException(NullPointerException ex) {
        // prepare responseEntity
        return new ResponseEntity<String>("name can not be null",HttpStatus.BAD_REQUEST);
    }

}
