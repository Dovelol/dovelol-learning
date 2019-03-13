package com.dove.lol.dovelol.service.impl;

import com.dove.lol.dovelol.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dovelol
 * @date 2019/3/11 22:44
 */
@Service
public class MyServiceImpl implements MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    @Autowired
    private MyService myService;

    public MyServiceImpl() {
        logger.info("MyServiceImpl 创建");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void test() {
        logger.info("test方法");
        test1();
    }

    @Override
    public void test1() {
        logger.info("test1方法");
    }
}

