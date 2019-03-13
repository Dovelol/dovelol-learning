package com.dove.lol.dovelol.service.impl;

import com.dove.lol.dovelol.model.User;
import com.dove.lol.dovelol.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dovelol
 * @date 2019/3/11 22:01
 */

@Service
public class TestServiceImpl implements TestService {

    public TestServiceImpl() {
        System.out.println("TestServiceImpl构造器");
    }

    @Override
    public Long selectById(Long id) {
        return 500L;
    }


    @Override
    public Long createUser(User user) {
        return user.getId();
    }
}
