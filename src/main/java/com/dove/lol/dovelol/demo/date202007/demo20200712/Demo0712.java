package com.dove.lol.dovelol.demo.date202007.demo20200712;

/**
 * @author Dovelol
 * @date 2020/7/12 16:43
 */
public class Demo0712 {


    public static void main(String[] args) {
        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6);


        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);           // true

    }

}
