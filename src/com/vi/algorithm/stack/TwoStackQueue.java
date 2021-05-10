package com.vi.algorithm.stack;

import java.util.Stack;

/**
 * 使用两个栈实现队列,支持队列的基本操作add,poll,peek
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int data) {
        stackPush.push(data);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("队列中没有数据");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("队列中没有数据");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public boolean isEmpty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TwoStackQueue queue = new TwoStackQueue();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        System.out.println(queue.peek());
    }
}
