package com.dove.lol.dovelol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dovelol
 * @date 2019/6/3 22:49
 */
@Controller
public class HelloWorldController {


    @Autowired
    private ApplicationContext context;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        Object a = context.getBean("a");
        Object b = context.getBean("b");
        return "Hello,World";
    }

}
