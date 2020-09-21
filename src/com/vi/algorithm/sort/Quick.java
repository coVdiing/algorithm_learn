package com.vi.algorithm.sort;

import java.util.Random;

//快速排序
public class Quick {
    public static void sort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    public static void sort(Comparable[] arr, int low, int high) {
        if (low >= high) {  //结束条件
            return;
        }
        //分组
        int mid = partition(arr, low, high);
        //左子组排序
        sort(arr, low, mid - 1);
        //右子组排序
        sort(arr, mid + 1, high);
    }

    public static int partition(Comparable[] arr, int low, int high) {
        //对判断基准的取值使用随机数，避免碰到逆序数组的时候，时间复杂度退化成O（n^2)，而且这种情况还很容易导致栈溢出
        Random random = new Random();
        int index = low + random.nextInt(high - low);
        swap(arr,low,index);
        Comparable key = arr[low];
        int leftPt = low;
        int rightPt = high + 1;

        while (true) {
            //从左往右找比第一个元素大的
            while (greater(key,arr[++leftPt])) {
                if (leftPt == high) {
                    break;
                }
            }
            //从右往左找比第一个元素小的
            while (greater(arr[--rightPt],key)) {
                if (rightPt == low) {
                    break;
                }
            }
            if (leftPt < rightPt) {
                swap(arr, leftPt, rightPt);
            } else {
                swap(arr, rightPt, low);
                break;
            }
        }
        return rightPt;
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
