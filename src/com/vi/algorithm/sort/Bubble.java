package com.vi.algorithm.sort;

/**
 * 冒泡排序
 */
public class Bubble {
    /**
     * 对arr进行排序
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(arr[j], arr[j + 1]))
                    exchange(arr, j, j+1);
            }
        }
    }

    /**
     * 判断两个元素的大小
     *
     * @param c1
     * @param c2
     */
    private static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) >= 0;
    }

    /**
     * 交换数组中i和j的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
