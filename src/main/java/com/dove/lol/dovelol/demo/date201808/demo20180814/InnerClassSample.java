package com.dove.lol.dovelol.demo.date201808.demo20180814;

import com.dove.lol.dovelol.utils.GlobalTheadPool;
import org.omg.CORBA.Environment;

import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/8/14 22:33
 */
public class InnerClassSample {

    public static void main(String[] args) {

        ((InnerB) () -> {
            int a = 10;
            System.out.println("abc");
        }).test();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8, 60L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"yzh");
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
                System.out.println("runnable!");
            }
        });

        int activeCount = executor.getActiveCount();
        System.out.println(activeCount);


    }


    class InnerA {

        private int age = 10;
    }


    interface InnerB {

        void test();

    }


}



