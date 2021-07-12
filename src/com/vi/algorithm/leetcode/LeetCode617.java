package com.vi.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: vi
 * @Date: 2021-06-23 22:49
 * @Version: 1.0
 * @Description:
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else {
            TreeNode root = new TreeNode();
            // root1,root2不同时为空
            if (root1 == null && root2 != null) {
                // root1为空,root2不为空
                root.val = root2.val;
                root.left = mergeTrees(null, root2.left);
                root.right = mergeTrees(null, root2.right);
            } else if (root1 != null && root2 == null) {
                // root1不为空,root2为空
                root.val = root1.val;
                root.left = mergeTrees(root1.left, null);
                root.right = mergeTrees(root1.right, null);
            } else {
                // 都不为空
                root.val = root1.val+root2.val;
                root.left = mergeTrees(root1.left, root2.left);
                root.right = mergeTrees(root1.right, root2.right);
            }
            return root;
        }
    }
}
