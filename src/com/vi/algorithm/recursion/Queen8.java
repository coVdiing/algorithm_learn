package com.vi.algorithm.recursion;

import java.util.Arrays;

//  八皇后问题求解
public class Queen8 {
    private static Integer[] arr = new Integer[8];
    private static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("共有" + count + "种解法");
    }

    //  摆放皇后
    private static void check(int n) {
        //  递归结束条件
        if (n == 8) {
            //  如果要摆放第9个皇后，说明之前的都已经摆放好了，本次摆放可行，回溯到n-1，寻找新的摆法
            count++;
            print(arr);
            return;
        }
        for (int i = 0; i < 8; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    //  检查摆放的位置是否冲突,n表示当前是第n个皇后，用arr[n]表示放在哪一列
    private static boolean judge(int n) {
        //  每次检查冲突需要和之前n-1个皇后比较
        for (int i = n - 1; i >= 0; i--) {
            //  两个皇后在同一列
            if (arr[i] == arr[n])
                return false;
            //  两个皇后在同一条斜线上
            if (Math.abs(i - n) == Math.abs(arr[i] - arr[n]))
                return false;
        }
        return true;
    }

    //  打印当前8皇后结果
    private static void print(Integer[] arr) {
        System.out.println(Arrays.asList(arr));
    }
}
