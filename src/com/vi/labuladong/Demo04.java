package com.vi.labuladong;

/**
 * @Author: vi
 * @Date: 2021-07-15 22:12
 * @Version: 1.0
 * @Description:最大子序和
 */
public class Demo04 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length;i++) {
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int max = nums[0];
        for(int i = 0;i < dp.length;i++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
