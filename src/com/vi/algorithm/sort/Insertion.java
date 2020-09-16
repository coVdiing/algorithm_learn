package com.vi.algorithm.sort;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] arr) {
        //外层循环控制比较n-1轮(n个数)
        for (int i = 1; i < arr.length; i++) {
            //内循环进行比较，每次一个元素和已经排序好的部分做比较，第一次默认首元素已经排序
            for (int j = i; j > 0; j--) {
                //如果元素j比j-1大，这轮结束，进入下一轮比较
                if(greater(arr[j],arr[j-1]))
                    break;
                //如果元素j小于j-1，交换它俩的位置
                swap(arr,j,j-1);
            }
        }
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
