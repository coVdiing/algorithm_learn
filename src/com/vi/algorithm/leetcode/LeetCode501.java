package com.vi.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @Author: vi
 * @Date: 2021-06-16 20:54
 * @Version: 1.0
 * @Description:
 */
public class LeetCode501 {
    TreeNode pre;
    int count = 0;
    int maxCount = 0;
    StringBuilder result = new StringBuilder();

    public int[] findMode(TreeNode root) {
        traversal(root);
        String s = result.toString();
        s = s.substring(0, s.length()-1);
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        return arr;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre == null) {
            count = 1;
            result.append(root.val+",");
        } else {
            if (pre.val == root.val) {
                // 重复节点计数加1
                count++;
            } else {
                // 新节点重新计数
                count = 1;
            }
            // 写入缓存
            if (count == maxCount) {
                result.append(root.val+",");
            } else if (count > maxCount) {
                result = new StringBuilder();
                result.append(root.val+",");
                maxCount = count;
            }
        }
        pre = root;
        traversal(root.right);
    }
}
