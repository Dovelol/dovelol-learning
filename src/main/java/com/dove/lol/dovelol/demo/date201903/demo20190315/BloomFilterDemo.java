package com.dove.lol.dovelol.demo.date201903.demo20190315;

/**
 * @author Dovelol
 * @date 2019/3/15 23:03
 */
public class BloomFilterDemo {

    private int[] array;

    private int size;

    public BloomFilterDemo(int size) {
        this.array = new int[size];
        this.size = size;
    }


    public void add(String key) {
        //计算hash
        int index1 = hashcode_1(key);
        int index2 = hashcode_2(key);
        int index3 = hashcode_3(key);

        array[index1 % size] = 1;
        array[index2 % size] = 1;
        array[index3 % size] = 1;
    }

    public boolean check(String key) {
        int index1 = hashcode_1(key);
        int index2 = hashcode_2(key);
        int index3 = hashcode_3(key);

        if (array[index1 % size] == 0) {
            return false;
        }

        if (array[index2 % size] == 0) {
            return false;
        }

        if (array[index3 % size] == 0) {
            return false;
        }
        return true;
    }


    /**
     * hash 算法1
     *
     * @param key
     * @return
     */
    private int hashcode_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * hash 算法2
     *
     * @param data
     * @return
     */
    private int hashcode_2(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * hash 算法3
     *
     * @param key
     * @return
     */
    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

}
