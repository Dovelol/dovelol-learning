package com.dove.lol.dovelol.controller;

import com.dove.lol.dovelol.model.User;
import com.dove.lol.dovelol.service.TestService;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    public TestController() {
        System.out.println("TestController构造器");
    }

    @Autowired
    private TestService testService;

    @GetMapping("/list")
    public List<String> getList(@RequestParam String key, @RequestParam String value) {
        List<String> list = new ArrayList<>();
        list.add(key);
        list.add(value);
        list.getClass().getInterfaces();
        new Thread("ThreadDemo-1") {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("123");
            }
        }.start();
        new Thread("ThreadDemo-1") {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("456");
            }
        }.start();


        return list;
    }

    @GetMapping("/test")
    public List<String> list(@RequestParam String key, @RequestParam String value) {
        List<String> list = new ArrayList<>();
        list.add(key);
        list.add(value);
        testService.selectById(100L);
        User user = new User();
        testService.createUser(user);
        return list;
    }

    @GetMapping("/test1")
    public String test1(@RequestParam String key, @RequestParam String value, HttpServletRequest request) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String tmp = null;
            while ((tmp=br.readLine()) != null){
                stringBuilder.append(tmp);
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key+":"+value;
    }

    @PostMapping("/test2")
    public String test2(@RequestParam String key, @RequestParam String value, HttpServletRequest request){
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String tmp = null;
            while ((tmp=br.readLine()) != null){
                stringBuilder.append(tmp);
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key+":"+value;
    }


    public static void main(String[] args) {
        Thread thread = new Thread();
    }

}
