package com.dove.lol.dovelol.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Dovelol
 * @date 2018/4/21 18:23
 */

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    /**
     * other
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.get(t) != null) {
                result[0] = map.get(t);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
