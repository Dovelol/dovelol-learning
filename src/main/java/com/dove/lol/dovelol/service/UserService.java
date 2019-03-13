package com.dove.lol.dovelol.service;

import com.dove.lol.dovelol.model.User;

public interface UserService {

    User selectById(Long id);

    Long createUser(User user);


}
