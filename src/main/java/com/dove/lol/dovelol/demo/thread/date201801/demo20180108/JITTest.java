package com.dove.lol.dovelol.demo.thread.date201801.demo20180108;

/**
 * @author Dovelol
 * @date 2018/1/8 23:01
 */
public class JITTest {

    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                while (!init){
                    int i = 0;
                }
                /**
                 * while(true){
                 *
                 * }
                 */
            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                init = true;
                System.out.println("set init to true.");
            }
        }.start();

    }


}
