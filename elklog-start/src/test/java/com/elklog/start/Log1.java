package com.elklog.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class Log1 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Log1.class);
        MDC.put("traceID", UUID.randomUUID().toString().replace("-", ""));
        logger.info("hello, world");

        Thread.sleep(1000*3);
    }
}
