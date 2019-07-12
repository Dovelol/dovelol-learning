package com.dove.lol.dovelol.daily.practise.q20190711;

/**
 * @author Dovelol
 * @date 2019/7/12 22:43
 */
public class Bleep {

    /**
     *  以上程序输出内容是？
     *  (a) Bleep
     *  (b) Blat
     *  (c) 程序编译错误
     *  (d) 以上都不是
     */


    private String name = "Bleep";

    void setName(String name) {
        this.name = name;
    }

    void backgroundSetName() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                setName("Blat");
            }
        };
        t.start();
        t.join();
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {
        new Bleep().backgroundSetName();
    }

}
