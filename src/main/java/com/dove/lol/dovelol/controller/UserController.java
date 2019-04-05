package com.dove.lol.dovelol.controller;

import com.dove.lol.dovelol.model.User;
import com.dove.lol.dovelol.service.MyService;
import com.dove.lol.dovelol.service.UserService;
import com.dove.lol.dovelol.service.impl.UserServiceImpl;
import com.dove.lol.dovelol.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dovelol
 * @date 2019/3/11 22:42
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController() {
        logger.info("UserController 创建了");
    }

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private MyService myService;

    @GetMapping(value = "/user")
    public ApiResponse<?> getUser(@RequestParam(value = "id") Long id) {
        myService.test();
        return new ApiResponse<>(ApiResponse.Status.SUCCESS, userServiceImpl.selectById(id));
    }

    @PostMapping(value = "/user")
    public ApiResponse<?> createUser(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        Long id = userServiceImpl.createUser(user);
        user.setId(id);
        return new ApiResponse<>(ApiResponse.Status.SUCCESS, user);
    }

}
