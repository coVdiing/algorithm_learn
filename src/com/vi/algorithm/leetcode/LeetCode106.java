package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-06-12 17:12
 * @Version: 1.0
 * @Description: 从中序遍历和后序遍历构建二叉树
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        int leftChildSize = rootIndex - inStart;
        root.val = postorder[postEnd];
        root.left = buildTree(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftChildSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftChildSize, postEnd - 1);
        return root;
    }
}
