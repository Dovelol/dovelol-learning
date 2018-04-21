package com.dove.lol.dovelol.demo.thread.date201803.demo20180328;

/**
 * @author Dovelol
 * @date 2018/3/28 23:24
 */
public class Student implements Cloneable{

    private String name;

    private int age;

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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
