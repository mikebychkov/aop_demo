package com.aop_demo;

import com.aop_demo.config.DemoConfig;
import com.aop_demo.dao2.TestDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppAround {

    private final static Logger logger = LogManager.getLogger(AppAround.class);

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfig.class);

        TestDAO dao = ac.getBean(TestDAO.class);
        List<String> rsl = dao.findSomething();
        logger.debug(rsl);

        ac.close();
    }
}
