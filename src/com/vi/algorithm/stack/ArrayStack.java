package com.vi.algorithm.stack;

import org.omg.CORBA.Object;

//  数组模拟栈
public class ArrayStack<T> {
    private int maxSize;
    private int top = -1;
    private T[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack =(T[])new Integer[maxSize];
    }

    //  判断栈是否已满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //  判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //  入栈
    public boolean push(T t) {
        if (isFull()) {
            System.out.println("栈已满!");
            return false;
        }
        top++;
        stack[top] = t
        ;
        return true;
    }

    //  出栈
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        T result = stack[top];
        stack[top--] = null;
        return result;
    }

    //  遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}
