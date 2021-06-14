package com.vi.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: vi
 * @Date: 2021-06-14 11:01
 * @Version: 1.0
 * @Description:左叶子之和
 */
public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = recordValue(root, new ArrayList<Integer>(),0);
        int sum = 0;
        for(Integer ele: list)
            sum += ele;
        return sum;
    }

    public static List<Integer> recordValue(TreeNode root, List<Integer> list,int flag) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null && flag == 1) {
            list.add(root.val);
        }
        recordValue(root.left,list,1);
        recordValue(root.right, list,0);
        return list;
    }
}
