package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-05-30 20:53
 * @Version: 1.0
 * @Description: 翻转二叉树
 */
public class LeetCode226 {
    public static TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;
    }


}
