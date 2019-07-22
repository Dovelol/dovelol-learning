package com.dove.lol.dovelol.demo.date201907.demo20190719;

/**
 * @author Dovelol
 * @date 2019/7/19 22:22
 */
public class LoadDemo {

    private static String d = "demo";

    public LoadDemo() {
        System.out.println("LoadDemo");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //System.out.println(d);
        Class<?> aClass = Class.forName("com.dove.lol.dovelol.demo.date201907.demo20190719.LoadDemo");
        System.out.println(aClass);
//        Object o = aClass.newInstance();
//        System.out.println(o);
    }

}
