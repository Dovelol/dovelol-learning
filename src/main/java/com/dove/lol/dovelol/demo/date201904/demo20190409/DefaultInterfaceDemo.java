package com.dove.lol.dovelol.demo.date201904.demo20190409;

/**
 * @author Dovelol
 * @date 2019/4/9 22:37
 */
public interface DefaultInterfaceDemo {

    void test1();


    default void defaultTest2(){
        System.out.println("This is a default method.");
    }

}
