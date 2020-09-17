package com.vi.algorithm.test;

public class TestFactorial {

    public static void main(String[] args) {
        long result = factorial(5);
        System.out.println(result);
    }

    //递归，求n的阶乘
    public static long factorial(int n) {
        if (n == 1) {
            return 1L;
        } else
            return n * factorial(n - 1);
    }
}
