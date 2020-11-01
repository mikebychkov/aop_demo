package com.aop_demo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private static final Logger logger = LogManager.getLogger(AccountDAO.class);

    public int addAccount() {
        logger.debug(getClass() + " ADD ACCOUNT METHOD \n\n");
        return 1;
    }

    public String getById(long id) {
        logger.debug(getClass() + " GETTING BY ID \n\n");
        return null;
    }
}
