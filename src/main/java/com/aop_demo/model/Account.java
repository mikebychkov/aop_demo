package com.aop_demo.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Account {

    private static final Logger logger = LogManager.getLogger(Account.class);

    private int id;

    public int getId() {
        logger.debug(getClass() + " getId() \n\n");
        return id;
    }

    public void setId(int id) {
        logger.debug(getClass() + " setId(int) \n\n");
        this.id = id;
    }

    public Account setAccountNumberAmount(int accountNumber, double amount, User owner) {
        logger.debug(getClass() + "setAccountNumberAmount(int, double, User)");
        return null;
    }
}
