package com.dove.lol.dovelol.mapper;

import com.dove.lol.dovelol.model.User;

public interface UserMapper {

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

}
