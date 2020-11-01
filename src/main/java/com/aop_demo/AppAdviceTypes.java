package com.aop_demo;

import com.aop_demo.config.DemoConfig;
import com.aop_demo.dao.SecureInfoDAO;
import com.aop_demo.model.SecureInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAdviceTypes {

    private static final Logger logger = LogManager.getLogger(AppAdviceTypes.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfig.class);

        SecureInfoDAO secureInfoDAO = ac.getBean(SecureInfoDAO.class);
        secureInfoDAO.addInfo(new SecureInfo(1));
        try {
            secureInfoDAO.addInfo(new SecureInfo());
        } catch(Exception e) {
            e.printStackTrace();
        }

        ac.close();
    }
}
