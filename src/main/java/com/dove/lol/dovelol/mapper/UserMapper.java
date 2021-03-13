package com.dove.lol.dovelol.mapper;

import com.dove.lol.dovelol.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    List<User> listUser(@Param(value="select") String select);

}
