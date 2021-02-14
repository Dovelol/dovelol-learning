package com.dove.lol.dovelol.demo.date202101.demo20210131;

import java.lang.reflect.Type;

/**
 * @author Dovelol
 * @date 2021/1/31 10:51
 */
public class GenericSubDemo extends GenericDemo<String>{

    public GenericSubDemo(String key) {
        super(key);
    }

        public static void main(java.lang.String[] args) {
            GenericSubDemo genericDemo = new GenericSubDemo("100");
            System.out.println(genericDemo.getKey());


            Type genericSuperclass = genericDemo.getClass().getGenericSuperclass();
            System.out.println(genericSuperclass);

        }
}
