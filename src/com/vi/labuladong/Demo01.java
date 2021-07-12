package com.vi.labuladong;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Author: vi
 * @Date: 2021-07-12 23:20
 * @Version: 1.0
 * @Description:斐波那契数列的备忘录解法
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(fib(20));
    }

    public static int fib(int n) {
        int[] list = new int[n+1];
        list[1] = list[2] = 1;
        for (int i = 3; i <= n; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[n];
    }
}
