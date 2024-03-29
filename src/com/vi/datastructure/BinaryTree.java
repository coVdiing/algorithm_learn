package com.vi.datastructure;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode();
        Integer data = inputList.removeFirst();
        if (data != null) {
            node.val = data;
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历二叉树
     *
     * @param head 二叉树头节点
     */
    public static void preOrderTraveral(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ->");
        preOrderTraveral(head.left);
        preOrderTraveral(head.right);
    }

    /**
     * 非递归遍历二叉树,前序方式
     *
     * @param node
     */
    public static void preOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ->");
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 非递归中序遍历二叉树
     *
     * @param node
     */
    public static void midOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ->");
                node = node.right;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param node
     */
    public static void levelOrderTraveral(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.val+"->");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode head = createBinaryTree(inputList);
//        preOrderTraveral(head);
//        System.out.println();
//        preOrderTraveralWithStack(head);
        System.out.print("中序遍历:");
        midOrderTraveralWithStack(head);
    }
}
