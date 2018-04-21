package com.dove.lol.dovelol.demo.date201712.demo20171217;

/**
 * @author Dovelol
 * @date 2017/12/17 10:38
 */
public class ImmutablePerformance {

    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("dovelol");
        ImmutableObj immutableObj = new ImmutableObj("dovelol");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (long l = 0; l < 10000000; l++) {
                    System.out.println(syncObj.toString());
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (long l = 0; l < 10000000; l++) {
                    System.out.println(syncObj.toString());
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();
        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTimestamp - startTimestamp));
    }

}

class ImmutableObj {
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SyncObj {
    private String name;

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "SyncObj{" +
                "name='" + name + '\'' +
                '}';
    }
}