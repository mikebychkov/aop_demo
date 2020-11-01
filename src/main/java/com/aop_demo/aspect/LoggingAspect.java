package com.aop_demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    //@Before("execution(public void addItem())")
    //@Before("execution(public void com.aop_demo.dao.AccountDAO.addItem())")
    @Before("execution(public * add*())")
    public void executeBeforeMethod() {
        logger.debug("===========EXECUTING BEFORE ADD METHOD (LOGGING ASPECT)");
    }

    @Before("execution(* getBy*(*))") // ONE PARAM WILDCARD
    public void executeBeforeParamMethod() {
        logger.debug("===========EXECUTING BEFORE PARAMETRIZED METHOD");
    }

    @Before("execution(* com.aop_demo.dao.*.*(..))") // ZERO TO MANY PARAM WILDCARD
    public void executeBeforeAllMethodsInPackage() {
        logger.debug("===========EXECUTING BEFORE METHODS IN DAO PACKAGE");
    }

    @Pointcut("execution(* com.aop_demo.model.*.*(..))")
    private void modelMethods() {
    }

    @Pointcut("execution(* com.aop_demo.model.SecureInfo.*(..))")
    private void secureInfo() {
    }

    @Before("modelMethods() && !secureInfo()")
    public void executeMethod1BeforeModelMethods() {
        logger.debug("===========METHOD #1 BEFORE MODEL METHODS");
    }

    @Before("modelMethods() && !secureInfo()")
    public void executeMethod2BeforeModelMethods() {
        logger.debug("===========METHOD #2 BEFORE MODEL METHODS");
    }

    @Pointcut("execution(* com.aop_demo.model.*.set*(..))")
    private void modelSetters() {
    }

    @Before("modelMethods() && !modelSetters() && !secureInfo()")
    public void executeNotForSettersBeforeModelMethods() {
        logger.debug("===========METHOD - NOT FOR SETTERS - BEFORE MODEL METHODS");
    }

    @Before("modelSetters() && !secureInfo()")
    public void executeOnlyForSettersBeforeModelMethods(JoinPoint joinPoint) {
        logger.debug("===========METHOD - ONLY FOR SETTERS - BEFORE MODEL METHODS");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.debug("===========METHOD SIGNATURE: " + signature);
        String[] params = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            logger.debug("===========METHOD ARGUMENT: " + params[i] + " = " + args[i]);
        }
    }
}
