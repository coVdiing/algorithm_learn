package com.vi.algorithm.sort;

import java.util.Random;
//照搬视频里的代码
public class Quick2 {
    public static void sort(Comparable[] arr) {
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    private static void sort(Comparable[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int partition = partition(arr, low, high);
        sort(arr, low, partition - 1);
        sort(arr, partition + 1, high);
    }

    private static int partition(Comparable[] arr, int low, int high) {
        Comparable key = arr[low];
        int left = low;
        int right = high+1;
        while (true) {
            while (less(key, arr[--right])) {
                if (right == low) {
                    break;
                }
            }

            while (less(arr[++left], key)) {
                if (left == high) {
                    break;
                }
            }

            if (left >= right) {
                break;
            } else {
                swap(arr, left, right);
            }
        }
        swap(arr,low,right);
        return right;
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
