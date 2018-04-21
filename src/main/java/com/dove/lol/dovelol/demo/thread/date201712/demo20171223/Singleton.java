package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

/**
 * @author Dovelol
 * @date 2017/12/23 20:24
 */
public class Singleton {

    private final static Singleton instance = new Singleton();

    public static int x = 0;

    public  static int y;


    public Singleton() {
        x = 5;
        System.out.println(x+"===");
        y++;
    }

    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        //Singleton singleton = getInstance();
        System.out.println(Singleton.x);
        System.out.println(Singleton.y);
    }

}


