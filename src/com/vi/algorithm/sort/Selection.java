package com.vi.algorithm.sort;

/**
 * 选择排序
 */
public class Selection {
    //排序
    public static void sort(Comparable[] arr) {
        //i个元素需要比较i-1轮
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            //每一轮比较到数组最后一位
            for (int j = i + 1; j < arr.length; j++) {
                if (greater(arr[min], arr[j]))
                    min = j;
            }
            exchange(arr, i, min);
        }
    }

    //比较两个元素大小
    private static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    //交换两个元素的位置
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
