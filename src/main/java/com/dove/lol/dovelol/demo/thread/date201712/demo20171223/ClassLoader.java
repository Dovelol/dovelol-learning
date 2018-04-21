package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

/**
 * @author Dovelol
 * @date 2017/12/23 18:06
 */
public class ClassLoader {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Class clazz = dog.getClass();
        Class clazzd = Dog.class;
        try {
            Class clazzdd = Class.forName("com.dove.lol.dovelol.demo.thread.date201712.demo20171223.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

class Dog{

}
