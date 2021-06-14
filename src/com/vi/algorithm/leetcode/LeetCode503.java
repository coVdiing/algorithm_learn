package com.vi.algorithm.leetcode;

import com.vi.algorithm.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.vi.datastructure.TreeNode;

/**
 * @Author: vi
 * @Date: 2021-06-14 23:20
 * @Version: 1.0
 * @Description:  二叉搜索树的最小绝对差
 */
public class LeetCode503 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        getNodesDifference(root,list);
        return list.stream().min((o1,o2) -> o1>o2 ? 1:-1).get();
//        int min = Integer.MAX_VALUE;
//        for (Integer ele : list) {
//            if (min > ele) {
//                min = ele;
//            }
//        }
//        return min;
    }

    public void getNodesDifference(TreeNode root, List<Integer> list) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        int leftValue = 0;
        int rightValue = 0;
        if (root.left != null) {
            leftValue = root.left.val;
            getNodesDifference(root.left,list);
            getNodesDifference(root.right,list);
        } else {
            rightValue = root.right.val;
            list.add(Math.abs(root.val - rightValue));
            getNodesDifference(root.left,list);
            getNodesDifference(root.right,list);
            return;
        }

        if (root.right != null) {
            rightValue = root.right.val;
        } else {
            leftValue = root.left.val;
            list.add(Math.abs(root.val - leftValue));
            return;
        }
        int result = Math.min(Math.abs(root.val - leftValue), Math.abs(root.val - rightValue));
        list.add(result);
        getNodesDifference(root.left,list);
        getNodesDifference(root.right,list);
    }

    public static void main(String[] args) {
        Integer[] arr = {236,104,701,null,227,null,911};
        TreeNode root = TreeUtil.buildTree(arr);
        System.out.println(new LeetCode503().getMinimumDifference(root));
    }

}
