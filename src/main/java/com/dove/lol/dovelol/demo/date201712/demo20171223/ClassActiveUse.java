package com.dove.lol.dovelol.demo.date201712.demo20171223;

import java.util.Random;

/**
 * @author Dovelol
 * @date 2017/12/23 19:42
 */
public class ClassActiveUse {

    public static void main(String[] args) {
        //new Obj();
        //System.out.println(I.a);
        //int i  =I.a;
        //System.out.println(Obj.salary);
        //Obj.printSalary();
//        try {
//            Obj obj = Obj.class.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        try {
            Class clazz = Class.forName("com.dove.lol.dovelol.demo.date201712.demo20171223.Obj");
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Child child = new Child();
        //System.out.println(Child.c);
        //System.out.println(Child.salary);
        //Obj[] objs = new Obj[0];

        //System.out.println(Obj.salary);
        //System.out.println(Child.x);

//        String a = "a";
//        String b = "b";
//        String ab = a + b;
//        System.out.println(ab == "ab");


    }
}

class Obj {

    public static final long salary = 100000L;

    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("父类static");
    }

    public Obj() {
        System.out.println("父类构造方法");
    }

    public static void printSalary() {
        System.out.println("=======");
    }
}

class Child extends Obj {

    public static int c = 10;

    static {
        System.out.println("子类static");
    }

    public Child() {
        System.out.println("子类构造方法");
    }
}

interface I {

    int a = 10;
}
