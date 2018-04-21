package com.dove.lol.dovelol.demo.thread.date201803.demo20180327;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2018/3/27 23:10
 */
public class InsertionSortingSample {

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 6, 2, 7, 3, 9, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (array[j] < array[j - 1]) {
//                    int temp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = temp;
//                } else {
//                    break;
//                }
//            }
//        }

        for (int i = 0, j = i; i < array.length-1; j = ++i) {
            int ai = array[i + 1];
            while (ai < array[j]) {
                array[j + 1] = array[j];
                if (j-- == 0) {
                    break;
                }
            }
            array[j + 1] = ai;
        }
    }

}
