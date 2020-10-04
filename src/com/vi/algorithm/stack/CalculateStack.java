package com.vi.algorithm.stack;

import com.vi.algorithm.linear.LinkList;

//  计算器栈，用于实现加减乘除的计算器,在链表实现的栈的基础上，对功能做扩展
public class CalculateStack<T> extends LinkListStack<T> {

    public CalculateStack() {
    }

    //  判断当前元素是否操作符
    public static boolean isCommand(String str) {
        return str.matches("[\\+\\-\\*\\/]");
    }

    //  判断当前操作符的优先级
    public static int priority(String str) {
        if ("+".equals(str))
            return 0;
        if ("-".equals(str))
            return 1;
        if ("*".equals(str) || "/".equals(str))
            return 2;
        throw new RuntimeException("非法操作符");
    }

    public static void main(String[] args) {
//        System.out.println(new CalculateStack<>().isCommand("\\"));
        CalculateStack<Integer> cs = new CalculateStack<>();
        cs.push(1);
        cs.push(2);
        cs.push(3);

        System.out.println(cs.peek());
        cs.list();
    }

}
