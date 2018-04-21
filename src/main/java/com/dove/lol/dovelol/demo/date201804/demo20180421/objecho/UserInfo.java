package com.dove.lol.dovelol.demo.date201804.demo20180421.objecho;

import org.msgpack.annotation.Message;

/**
 * @author Dovelol
 * @date 2018/4/21 13:22
 */
@Message
public class UserInfo {


    private String name;

    private int age;

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
