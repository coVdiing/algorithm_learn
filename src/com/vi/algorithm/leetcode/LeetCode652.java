package com.vi.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: vi
 * @Date: 2021-06-14 19:41
 * @Version: 1.0
 * @Description:
 */
public class LeetCode652 {
    HashMap<String, Integer> nodeCount = new HashMap<>();
    LinkedList<TreeNode> result = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    public String traverse(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String left = traverse(node.left);
        String right = traverse(node.right);
        String nodeStr = node.val +","+left+","+right;
        Integer isExist = nodeCount.getOrDefault(nodeStr, 0);
        if (isExist == 1) {
            result.add(node);
        }
        if (nodeCount.containsKey(nodeStr)) {
            Integer count = nodeCount.get(nodeStr);
            nodeCount.put(nodeStr, count + 1);
        } else {
            nodeCount.put(nodeStr, 1);
        }
        return nodeStr;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.getOrDefault("1", 0);
    }
}
