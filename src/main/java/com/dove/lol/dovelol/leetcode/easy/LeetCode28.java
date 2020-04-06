package com.dove.lol.dovelol.leetcode.easy;

/**
 * @author Dovelol
 * @date 2020/4/2 22:46
 */
public class LeetCode28 {


    public static void main(String[] args) {

        System.out.println(strStr("",""));

    }

    public static int strStr(String haystack, String needle) {
        if("".equals(needle) && "".equals(haystack)){
            return 0;
        }
        if("".equals(needle) ){
            return 0;
        }
        if( "".equals(haystack)){
            return -1;
        }


        int needleLen = needle.length();
        int haystackLen  = haystack.length();
        if(haystackLen < needleLen){
            return -1;
        }
        for(int i = 0; i < haystack.length(); i++){
            if(i+needleLen>haystackLen){
                break;
            }
            String substring = haystack.substring(i, i+needleLen);
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;

    }

}
