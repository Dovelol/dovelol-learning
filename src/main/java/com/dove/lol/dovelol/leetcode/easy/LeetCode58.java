package com.dove.lol.dovelol.leetcode.easy;

/**
 * @author Dovelol
 * @date 2020/4/4 22:36
 */
public class LeetCode58 {


    public int lengthOfLastWord(String s) {
        if("".equals(s) || s == null){
            return 0;
        }
        String[] split = s.split(" ");
        int index = split.length;
        return split[index-1].length();

    }

}
