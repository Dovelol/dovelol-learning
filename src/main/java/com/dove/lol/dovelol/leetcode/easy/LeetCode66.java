package com.dove.lol.dovelol.leetcode.easy;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2020/4/6 22:43
 */
public class LeetCode66 {

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }


    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }

        boolean flag = true;
        for(int i = digits.length-1; i >= 0; i--){
            int tempSum;
            if(flag){
                tempSum = digits[i] + 1;
            }else {
                break;
            }
            if(tempSum == 10){
                digits[i] = 0;
                flag = true;
            }else {
                digits[i] = tempSum;
                flag = false;
            }
            if(i == 0 && flag){
                // copy一个数组
                int[] newDigits = new int[digits.length+1];
//                System.arraycopy(digits,0,newDigits,1,digits.length);
                newDigits[0] = 1;
                digits = newDigits;
            }
        }
        return digits;
    }

}
