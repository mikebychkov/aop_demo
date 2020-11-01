package com.aop_demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AroundAspect {

    private static final Logger logger = LogManager.getLogger(AroundAspect.class);

    @Around("execution(* com.aop_demo.dao2.TestDAO.*(..))")
    public List<String> executeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("===========<AROUND> SECURE INFO METHOD");
        long begin = System.currentTimeMillis();
        List<String> rsl = (List<String>) joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.debug("===========PROCEEDING TIME (MS): " + (end - begin));
        return rsl;
    }
}
