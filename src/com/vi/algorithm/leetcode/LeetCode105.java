package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-06-12 16:49
 * @Version: 1.0
 * @Description:
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int indexOfRoot = -1;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode();
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                // 先序的第一个元素就是根节点
                indexOfRoot = i;
            }
        }
        // 中序遍历，indexOfRoot左边的是左子树，右边的是右子树
        int leftChildSize = indexOfRoot - inStart + 1;
        root.val = rootVal;
        root.left = buildTree(preorder,preStart+1,leftChildSize-1+preStart,
                                inorder,inStart,indexOfRoot-1);
        root.right = buildTree(preorder,leftChildSize+preStart,preEnd,
                inorder,indexOfRoot+1,inEnd);
        return root;
    }

}
