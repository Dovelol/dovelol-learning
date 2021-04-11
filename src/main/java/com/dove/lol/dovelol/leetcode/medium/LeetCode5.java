package com.dove.lol.dovelol.leetcode.medium;

import java.util.Objects;

/**
 * @author Dovelol
 * @date 2021/4/1 22:38
 */
public class LeetCode5 {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabb"));
    }

    public static String longestPalindrome(String s) {
        // 找出所有的回文串，比较长度
        int length = s.length();
        if(length==1){
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < length-1; i++){
            for (int j = i+1; j < length; j ++){
                if(j-i+1 > maxLen && check(chars,i ,j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return  s.substring(begin,begin+maxLen);
    }

    public static boolean check(char[] chars,int left,int right){
        while (left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
