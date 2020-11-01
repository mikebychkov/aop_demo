package com.aop_demo;

import com.aop_demo.config.DemoConfig;
import com.aop_demo.dao.AccountDAO;
import com.aop_demo.dao.UserDAO;
import com.aop_demo.model.Account;
import com.aop_demo.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfig.class);

        //

        AccountDAO accountDAO = ac.getBean(AccountDAO.class);
        UserDAO userDAO = ac.getBean(UserDAO.class);

        accountDAO.addAccount();
        userDAO.addUser();

        accountDAO.getById(1L);
        userDAO.getById(1);

        //

        Account account = ac.getBean(Account.class);
        account.setId(1);
        account.getId();

        account.setAccountNumberAmount(1, 1, new User("Edgar Alan Poe"));

        //

        ac.close();
    }
}
