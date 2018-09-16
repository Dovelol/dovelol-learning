package com.dove.lol.dovelol.demo.date201807.demo20180714;

import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

/**
 * @author Dovelol
 * @date 2018/7/14 10:55
 */

@Service
public class ClassLoaderDemo {

    public static void main(String[] args) {
        Annotation[] annotations = ClassLoaderDemo.class.getAnnotations();
        System.out.println();
    }

}
