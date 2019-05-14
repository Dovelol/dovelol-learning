package com.dove.lol.dovelol.demo.date201905.demo20190512;

import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dovelol
 * @date 2019/5/12 11:35
 */
public class ClassDemoImpl implements ClassDemo {

    private Map<Integer, List<String>> myMap;

    public static void main(String[] args) throws NoSuchFieldException {
        boolean present = ClassUtils.isPresent("com.dove.lol.dovelol.demo.date201905.demo20190512.ClassDemo1", null);
        System.out.println(present);

        ClassDemo classDemo = new ClassDemoImpl();

        System.out.println(ResolvableType.forInstance(classDemo));


        ResolvableType t = ResolvableType.forField(classDemo.getClass().getDeclaredField("myMap"));
        t.getSuperType(); // AbstractMap&lt;Integer, List&lt;String&gt;&gt;
        t.asMap(); // Map&lt;Integer, List&lt;String&gt;&gt;
        System.out.println(t.getGeneric(0).resolve()); // Integer
        System.out.println(t.getGeneric(1).resolve()); // List
        System.out.println(t.getGeneric(1)); // List&lt;String&gt;
        System.out.println(t.resolveGeneric(1, 0)); // String


    }


}
