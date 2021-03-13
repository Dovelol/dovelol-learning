package com.dove.lol.dovelol.service;

import com.dove.lol.dovelol.model.User;

import java.util.List;

public interface UserService {

    User selectById(Long id);

    Long createUser(User user);

    List<User> listUser(String select);
}
