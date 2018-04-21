package com.dove.lol.dovelol.leetcode.medium;

import java.util.HashSet;

/**
 * @author Dovelol
 * @date 2018/4/21 19:26
 */
public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<>();
        //首位
        int first = 0;
        //末位
        int last = 0;
        //s长度
        int size = s.length();
        //最长字符串长度
        int maxSize = 0;
        while (first < size && last < size) {
            if (!hashSet.contains(s.charAt(last))) {
                hashSet.add(s.charAt(last++));
                maxSize = Math.max(maxSize, last - first);
            } else {
                hashSet.remove(s.charAt(first++));
            }
        }
        return maxSize;
    }

}
