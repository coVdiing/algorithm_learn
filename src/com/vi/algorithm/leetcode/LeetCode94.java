package com.vi.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: vi
 * @Date: 2021-05-29 15:28
 * @Version: 1.0
 * @Description:
 */
public class LeetCode94 {

    public static TreeNode buildTree(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = buildTree(list);
            node.right = buildTree(list);
        }
        return node;
    }

    // 中序遍历二叉树
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list,root);
        return list;
    }

    public static void traversal(List<Integer> list,TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(list,root.left);
        list.add(root.val);
        traversal(list,root.right);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] arr = {1,2};
        list.addAll(Arrays.asList(arr));
        TreeNode treeNode = buildTree(list);
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}