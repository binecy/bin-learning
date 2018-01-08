package com.springboot.start.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTests {
    private Logger logger = LoggerFactory.getLogger(ApplicationTests.class);


    @Test
    public void testAdd() {
        logger.info("test................");
    }
}
