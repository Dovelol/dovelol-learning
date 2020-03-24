package com.dove.lol.dovelol.demo.date201904.demo20190409;

/**
 * @author Dovelol
 * @date 2019/4/9 22:41
 */
public class DefaultInterfaceImplDemo implements DefaultInterfaceDemo {

    @Override
    public void test1() {

    }

    @Override
    public void defaultTest2() {
        System.out.println("This is handler default impl method.");
    }

    public static void main(String[] args) {
        DefaultInterfaceDemo demo  = new DefaultInterfaceImplDemo();
        demo.defaultTest2();
    }


}
