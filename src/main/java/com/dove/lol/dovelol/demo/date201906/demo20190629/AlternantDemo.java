package com.dove.lol.dovelol.demo.date201906.demo20190629;

import com.dove.lol.dovelol.utils.GlobalTheadPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2019/6/29 22:59
 */
public class AlternantDemo {


    private static final Object OBJECT1 = new Object();


    public static void main(String[] args) throws InterruptedException {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "alternant-" + counter.incrementAndGet()));
        executorService.execute(() -> numberList.forEach(number -> {
            synchronized (OBJECT1) {
                OBJECT1.notify();
                System.out.println(number);
                try {

                    OBJECT1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));


        executorService.execute(() -> alphabetList.forEach(alphabet -> {
            synchronized (OBJECT1) {
                OBJECT1.notify();
                System.out.println(alphabet);
                try {
                    OBJECT1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        executorService.shutdown();

    }



}
