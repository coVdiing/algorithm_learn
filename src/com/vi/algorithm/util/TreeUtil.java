package com.vi.algorithm.util;

import com.vi.datastructure.TreeNode;

/**
 * @Author: vi
 * @Date: 2021-06-12 14:34
 * @Version: 1.0
 * @Description: 二叉树工具类
 */
public class TreeUtil {
    public static TreeNode buildTree(Integer[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                nodes[i] = null;
            else
                nodes[i] = new TreeNode(arr[i]);
        }
        // 叶子节点下标减2除以2等于父节点的下标
        int lastParentIndex = (arr.length - 3) / 2;
        for (int i = 0; i <= lastParentIndex; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[2 * i + 1];
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }
}
