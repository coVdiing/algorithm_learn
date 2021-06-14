package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-06-06 13:47
 * @Version: 1.0
 * @Description: 平衡二叉树
 */
public class LeetCode110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
