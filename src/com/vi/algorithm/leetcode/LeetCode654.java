package com.vi.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: vi
 * @Date: 2021-06-06 14:50
 * @Version: 1.0
 * @Description:
 */
public class LeetCode654 {
    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMaxTree(nums,0,nums.length-1);
    }

    public static TreeNode buildMaxTree(int[] arr, int start, int end) {
        if (arr == null || start > end) {
            return null;
        }
        int max = getMax(arr, start, end);
        TreeNode root = new TreeNode(arr[max]);
        root.left = buildMaxTree(arr, start, max - 1);
        root.right = buildMaxTree(arr, max + 1, end);
        return root;
    }

    public static int getMax(int[] arr, int start, int end) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
