package com.vi.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: vi
 * @Date: 2021-07-15 22:47
 * @Version: 1.0
 * @Description:下降路径最小和
 */
public class LeetCode931 {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        dp = new int[matrix.length][matrix.length];
        for (int j = 0; j < matrix[0].length; j++) {
            result = Math.min(result, dp(matrix, matrix.length - 1, j));
        }
        return result;
    }

    /**
     * 返回从第0行下降到i,j这个位置所经历的路径最小和
     *
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public int dp(int[][] matrix, int i, int j) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) {
            return 66666;
        }
        // dp[i][j] 里保存到达ij的最小路径和
        for (int x = 0; x < dp.length; x++) {
            Arrays.fill(dp[x], 66666);
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (dp[i][j] != 66666) {
            return dp[i][j];
        }
        dp[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j + 1));
        return dp[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
