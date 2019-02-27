package com.dove.lol.dovelol.demo.date201901.demo20190128;

import java.util.function.Supplier;

/**
 * @author Dovelol
 * @date 2019/1/28 22:46
 */
public class SupplierDemo {


    public static void main(String[] args) {
        Supplier<String> supplier = SupplierDemo::get;
        Supplier<Long> supplier1 = System::currentTimeMillis;
    }


    private static String get() {
        return "";
    }



}
