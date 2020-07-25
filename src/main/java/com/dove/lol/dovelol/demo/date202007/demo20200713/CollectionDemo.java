package com.dove.lol.dovelol.demo.date202007.demo20200713;

import java.util.*;

/**
 * @author Dovelol
 * @date 2020/7/13 22:01
 */
public class CollectionDemo<E> {

    public static void main(String[] args) {
        TreeSet<String> str1 = new TreeSet<>();

        str1.add("13");
        str1.add("3334");
        str1.add("13213");
        str1.add("11132313");
        str1.add("65467543");


        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(12);
        list.add(89);
        list.add(7);
        list.add(10);
        list.add(66);

        ListIterator<Integer> integerListIterator = list.listIterator();

        System.out.println(list);


        LinkedList<Integer> list1 = new LinkedList<>();
        list1.getFirst();
        list1.add(5);
        list1.add(12);
        list1.add(89);
        list1.add(7);
        list1.add(10);
        list1.add(66);

        System.out.println(list1);

        MyCollection<? extends SuperClass> myCollection = new MyCollection<SubClass>();

        //myCollection.remove(new SuperClass()); // 无法编译, 只能传入null

    }

    public boolean remove(E e) {
        if (e == null) {
        } else {

        }
        return false;
    }

}



 class SuperClass {

}


 class SubClass extends SuperClass{

}

 class MyCollection<T> {

     public void remove(T t) {
         System.out.println("remove t from mycollection");
     }
 }
