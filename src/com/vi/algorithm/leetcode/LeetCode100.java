package com.vi.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: vi
 * @Date: 2021-05-30 21:07
 * @Version: 1.0
 * @Description:相同的树
 */
public class LeetCode100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return judge(p, q);
    }

    public static boolean judge(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 两个节点都为空
            return true;
        } else if (p != null && q != null) {
            // 两个节点都不为空
            if (p.val != q.val) {
                // 父节点内容不同
                return false;
            }
            if (p.left != null && q.left != null) {
                // 判断左子节点是否相同
                if (p.left.val != q.left.val) {
                    return false;
                }
            }
            if ((p.left == null && q.left != null) || (p.left != null && q.left == null)) {
                // 一个有左子节点，一个没有
                return false;
            }
            if (p.right != null && q.right != null) {
                // 判断右子节点是否相同
                if (p.right.val != q.right.val) {
                    return false;
                }
            }
            if ((p.right == null && q.right != null) || (p.right != null && q.right == null)) {
                // 一个有右子节点，一个没有
                return false;
            }
            boolean leftFlag = judge(p.left, q.left);
            boolean rightFlag = judge(p.right, q.right);

            return leftFlag&rightFlag;
        } else {
            // 一个为空，一个不为空
            return false;
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, null, 2, 3};
        Integer[] arr2 = {1, null, 2, null, 3};
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addAll(Arrays.asList(arr1));
        TreeNode p = LeetCode94.buildTree(list1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(Arrays.asList(arr2));
        TreeNode q = LeetCode94.buildTree(list2);
        isSameTree(p, q);
    }
}
