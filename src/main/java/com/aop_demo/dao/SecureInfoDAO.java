package com.aop_demo.dao;

import com.aop_demo.model.SecureInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SecureInfoDAO {

    private static final Logger logger = LogManager.getLogger(SecureInfoDAO.class);

    private Map<Integer, SecureInfo> infos = new HashMap<>();

    public SecureInfo addInfo(SecureInfo info) {
        logger.debug(getClass() + " addInfo()");
        if(info.getId() == 0) {
            throw new IllegalArgumentException();
        }
        infos.put(info.getId(), info);
        return info;
    }

    public SecureInfo getInfo(SecureInfo info) {
        logger.debug(getClass() + " getInfo()");
        return infos.get(info.getId());
    }
}
