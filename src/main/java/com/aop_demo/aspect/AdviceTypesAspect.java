package com.aop_demo.aspect;

import com.aop_demo.model.SecureInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceTypesAspect {

    private static final Logger logger = LogManager.getLogger(AdviceTypesAspect.class);

    @Pointcut("execution(* com.aop_demo.dao.Secure*.*(..))")
    private void secureInfoMethods() {
    }

    @Before("secureInfoMethods()")
    public void executeBefore(JoinPoint joinPoint) {
        logger.debug("===========<BEFORE> SECURE INFO METHOD");
    }

    @AfterReturning(value = "secureInfoMethods()", returning = "result")
    public void executeAfterReturning(JoinPoint joinPoint, SecureInfo result) {
        logger.debug("===========<AFTER RETURNING> SECURE INFO METHOD===RESULT: " + result);
    }

    @AfterThrowing(value = "secureInfoMethods()", throwing = "result")
    public void executeAfterThrowing(JoinPoint joinPoint, Throwable result) {
        logger.debug("===========<AFTER THROWING> SECURE INFO METHOD===RESULT: " + result);
    }

    @After("secureInfoMethods()")
    public void executeAfter(JoinPoint joinPoint) {
        logger.debug("===========<AFTER> SECURE INFO METHOD");
    }
}
