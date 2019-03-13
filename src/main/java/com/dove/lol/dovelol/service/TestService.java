package com.dove.lol.dovelol.service;

import com.dove.lol.dovelol.model.User;

/**
 * @author Dovelol
 * @date 2019/3/11 22:00
 */
public interface TestService {

    Long selectById(Long id);

    Long createUser(User user);

}
