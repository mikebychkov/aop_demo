package com.aop_demo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAO.class);

    public String addUser() {
        logger.debug(getClass() + " DOING SOME DAO JOBS \n\n");
        return "User name";
    }

    public String getById(int id) {
        logger.debug(getClass() + " GETTING BY ID \n\n");
        return null;
    }
}
