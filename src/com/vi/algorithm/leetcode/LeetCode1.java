package com.vi.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: vi
 * @Date: 2021-05-21 7:58
 * @Version: 1.0
 * @Description:
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        LeetCode1 lc1 = new LeetCode1();
        int[] sum = lc1.twoSum(nums, target);
        System.out.println(sum[0]);
        System.out.println(sum[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] clone = nums.clone();
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            index = nums.length;
        }
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] == result[0]) {
                result[0] = i;
            } else if (clone[i] == result[1]) {
                result[1] = i;
            }
        }
        return result;
    }
}
