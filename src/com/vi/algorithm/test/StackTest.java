package com.vi.algorithm.test;

import com.vi.algorithm.stack.ArrayStack;
import com.vi.algorithm.stack.LinkListStack;

import java.util.Scanner;

public class StackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayStack stack = new ArrayStack(4);
        LinkListStack stack = new LinkListStack();
        boolean flag = true;
        while (flag) {
            System.out.println("***按照序号选择功能***");
            System.out.println("1.入栈");
            System.out.println("2.出栈");
            System.out.println("3.遍历");
            System.out.println("4.退出");
            String command = sc.nextLine();
            switch (command) {
                case "1":
                    String target = sc.nextLine();
                    stack.push(Integer.parseInt(target));
                    break;
                case "2":
                    System.out.println(stack.pop()+"出栈!");
                    break;
                case "3":
                    stack.list();
                    break;
                case "4":
                    flag = false;
                    sc.close();
            }
        }
        System.out.println("程序退出!");
    }
}
