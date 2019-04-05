package com.dove.lol.dovelol.service.impl;

import com.dove.lol.dovelol.mapper.UserMapper;
import com.dove.lol.dovelol.model.User;
import com.dove.lol.dovelol.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dovelol
 * @date 2019/3/11 22:30
 */

@Service
public class UserServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
        logger.info("UserServiceImpl 创建");
    }

    public User selectById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        logger.info("user:" + user);
        return user;
    }

    //@Transactional(rollbackFor = Exception.class)
    public Long createUser(User user) {
        userMapper.insertSelective(user);
        return user.getId();
    }

}
