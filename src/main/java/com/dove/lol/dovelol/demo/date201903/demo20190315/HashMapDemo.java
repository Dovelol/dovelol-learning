package com.dove.lol.dovelol.demo.date201903.demo20190315;

/**
 * @author Dovelol
 * @date 2019/3/15 22:52
 */
public class HashMapDemo {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < 10000000; i++) {
//            set.add(i);
//        }
        int size = 1000000;
        BloomFilterDemo bloomFilterDemo = new BloomFilterDemo(size);
        for (int i = 0; i < size; i++) {
            bloomFilterDemo.add(String.valueOf(i));
        }
        System.out.println(bloomFilterDemo.check("1"));
        System.out.println(bloomFilterDemo.check("100"));
        System.out.println(bloomFilterDemo.check("400230340"));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }

}
