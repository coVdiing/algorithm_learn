package com.vi.algorithm.leetcode;

import com.vi.algorithm.util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import com.vi.datastructure.TreeNode;

/**
 * @Author: vi
 * @Date: 2021-06-12 14:09
 * @Version: 1.0
 * @Description: 二叉树非递归后序遍历
 */
public class LeetCode145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null)
            return null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                result.addFirst(root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;
            }
        }
        return result;
    }

}
