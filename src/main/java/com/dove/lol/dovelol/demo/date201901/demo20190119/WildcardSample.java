package com.dove.lol.dovelol.demo.date201901.demo20190119;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dovelol
 * @date 2019/1/19 21:40
 */
public class WildcardSample {


    public static void demo1(List<? extends Number> producer) {

        Number number = (Number) producer.get(0);
    }

    public static void demo2(List<? super B> producer, List<? extends B> consumer) {
        B b = new B();

        producer.add(new B());

        A a = consumer.get(0);
        C c = (C)producer.get(0);
    }

}


class A{

}

class B extends A{

}

class C extends B{

}