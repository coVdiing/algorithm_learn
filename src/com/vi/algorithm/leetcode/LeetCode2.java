package com.vi.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: vi
 * @Date: 2021-05-20 7:45
 * @Version: 1.0
 * @Description:
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int sum;
        int num1;
        int num2;
        int plus = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            num1 = 0;
            num2 = 0;
            plus = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop();
            }
            sum = num1 + num2 + plus;
            if (sum > 10) {
                plus = 1;
                sum = sum % 10;
            }
            queue.add(sum);
        }
        if (plus == 1) {
            queue.add(1);
        }

        ListNode start = new ListNode(queue.poll());
        ListNode temp = start;
        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }
        return start;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
