package com.vi.algorithm.stack;

import com.vi.algorithm.linear.LinkList;

//  用链表实现栈
public class LinkListStack<T> {
    private LinkList<T> stack;

    public LinkListStack() {
        stack = new LinkList<T>();
    }

    //  链表式的不存在存满的情况
    public boolean isFull() {
        return false;
    }

    //  判断是否为空
    public boolean isEmpty() {
        return stack.length() == 0;
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("栈为空！");
            return null;
        }
        T result = stack.remove(stack.length() - 1);
        return result;
    }

    public boolean push(T data) {
        try {
            stack.insert(data);
        } catch (Exception e) {
            System.out.println("插入失败！");
            return false;
        }
        return true;
    }

    //  遍历
    public void list() {
        if (stack.isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        for (int i = stack.length() - 1; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack.get(i));
        }
    }
}
