package com.aop_demo.dao2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDAO {

    private static final Logger logger = LogManager.getLogger(TestDAO.class);

    public List<String> findSomething() throws InterruptedException {
        logger.debug(getClass() + " findSomething()");
        Thread.sleep(1000);
        return List.of("String data #1", "String data #2", "String data #3");
    }
}
