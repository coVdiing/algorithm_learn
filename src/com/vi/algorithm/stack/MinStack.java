package com.vi.algorithm.stack;

import java.util.Stack;

/**
 * @author vi
 * 实现一个特殊的栈，在实现基本功能的前提下，再实现返回最小元素的操作
 * 要求:pop,push,getMin的时间复杂度都是O（1）
 * 思路：用两个栈实现，一个栈保存全部的数据，另一个栈按从小到大的顺序保存部分数据
 */

public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public int push(int data) {
        if (minStack.size() == 0) {
            minStack.push(data);
        } else {
            Integer peek = minStack.peek();
            if (data <= peek) {
                minStack.push(data);
            }
        }
        return dataStack.push(data);
    }

    public int pop() {
        int value = dataStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈中没有数据");
        }
        return minStack.peek();
    }

    public MinStack() {
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        int[] arr = {3, 4, 5, 1, 2, 1};
        for (Integer ele : arr) {
            minStack.push(ele);
        }
        System.out.println(minStack.getMin());
    }
}
