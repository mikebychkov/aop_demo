package com.aop_demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AnalyticsAspect {

    private static final Logger logger = LogManager.getLogger(AnalyticsAspect.class);

    @Before("execution(public * add*())")
    public void executeBeforeMethod() {
        logger.debug("===========EXECUTING BEFORE ADD METHOD (ANALYTICS ASPECT)");
    }
}
