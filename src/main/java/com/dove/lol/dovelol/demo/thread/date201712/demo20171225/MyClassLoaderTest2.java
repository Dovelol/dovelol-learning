package com.dove.lol.dovelol.demo.thread.date201712.demo20171225;

/**
 * @author Dovelol
 * @date 2017/12/25 22:43
 */
public class MyClassLoaderTest2 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader1 = new MyClassLoader("MyClassLoader-1");
        MyClassLoader myClassLoader2 = new MyClassLoader("MyClassLoader-2");
        myClassLoader2.setDir("e:\\xm");
        Class<?> aClass = myClassLoader1.loadClass("com.dove.lol.dovelol.demo.thread.date201712.demo20171225.MyObject");
        System.out.println(aClass.hashCode());
        Class<?> aClass2 = myClassLoader2.loadClass("com.dove.lol.dovelol.demo.thread.date201712.demo20171225.MyObject");
        System.out.println(aClass.hashCode());
        System.out.println(((MyClassLoader) aClass.getClassLoader()).getClassLoaderName());
        System.out.println(aClass.getClassLoader());
    }

}
