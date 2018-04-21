package com.dove.lol.dovelol.demo.date201712.demo20171223;

/**
 * @author Dovelol
 * @date 2017/12/23 20:49
 */
public class LoderClass {

    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();

        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
        System.out.println(myObject1.getClass() == myObject4.getClass());
    }

}

class MyObject{

}