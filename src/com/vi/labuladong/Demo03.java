package com.vi.labuladong;

import java.util.Arrays;

/**
 * @Author: vi
 * @Date: 2021-07-13 22:41
 * @Version: 1.0
 * @Description:最长递增子序列
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        // 定义dp数组，dp数组和nums中的元素对应，dp[i]的值是以nums[i]结尾的最长子序列长度
        int[] dp = new int[nums.length];
        // dp中元素初始化为1，因为每个元素即使只有自己这个序列长度也为1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = -1;
        for (int i = 0; i < dp.length; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}
