package com.dove.lol.dovelol.demo.date201907.demo20190704;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author Dovelol
 * @date 2019/7/4 22:33
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

        Exchanger<Object> exchanger = new Exchanger<>();
        Thread thread1 = new Thread(()-> numberList.forEach(number->{
            try {
                Object a = exchanger.exchange(number);
                Thread.sleep(1);
                System.out.println(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        Thread thread2 = new Thread(()-> alphabetList.forEach(a->{
            try {
                Object number = exchanger.exchange(a);
                System.out.println(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        thread1.start();
        thread2.start();

    }


}
