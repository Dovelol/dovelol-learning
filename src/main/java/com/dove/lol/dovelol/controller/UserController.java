package com.dove.lol.dovelol.controller;

import com.dove.lol.dovelol.DemoProperties;
import com.dove.lol.dovelol.model.User;
import com.dove.lol.dovelol.service.MyService;
import com.dove.lol.dovelol.service.UserService;
import com.dove.lol.dovelol.service.impl.UserServiceImpl;
import com.dove.lol.dovelol.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dovelol
 * @date 2019/3/11 22:42
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserServiceImpl userServiceImpl;

    private final MyService myService;

    @Autowired
    private DemoProperties demoProperties;

    public UserController(MyService myService, UserServiceImpl userServiceImpl) {
        logger.info("UserController 创建了");
        this.myService = myService;
        this.userServiceImpl = userServiceImpl;
    }

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

    @PostMapping(value = "/getUser")
    public ApiResponse<?> getUser(User user) {
        return new ApiResponse<>(ApiResponse.Status.SUCCESS, user);
    }


    @GetMapping(value = "/user/list")
    public ApiResponse<?> listUser(@RequestParam String select, @RequestHeader("trace") String trace ) {
        System.out.println("trace: "+trace);
        return new ApiResponse<>(ApiResponse.Status.SUCCESS, userServiceImpl.listUser(select));
    }

}
