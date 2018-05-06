package com.dove.lol.dovelol.demo.date201805.demo20180506;

/**
 * @author Dovelol
 * @date 2018/5/6 9:43
 */
public class Test {

    private String name;

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        try {

            Class<?> aClass1 = new Test().getClass().getClassLoader().loadClass("com.dove.lol.dovelol.demo.date201805.demo20180506.Test");
            Test test = (Test)aClass1.newInstance();
            System.out.println(test.name);

            Class<?> aClass = Class.forName("com.dove.lol.dovelol.demo.date201805.demo20180506.Test");
            Test test1 = (Test)aClass.newInstance();
            System.out.println(test1.name);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
