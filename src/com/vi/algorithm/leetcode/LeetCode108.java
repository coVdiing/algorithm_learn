package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-06-02 8:01
 * @Version: 1.0
 * @Description:
 */
public class LeetCode108 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid-1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
}
