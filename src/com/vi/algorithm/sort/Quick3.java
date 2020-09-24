package com.vi.algorithm.sort;

import java.util.Random;

import static com.vi.algorithm.sort.Quick.swap;

public class Quick3 {
    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Integer[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int paviotIndex = partition(arr, startIndex, endIndex);
        sort(arr, 0, paviotIndex - 1);
        sort(arr, paviotIndex + 1, endIndex);
    }

    private static int partition(Integer[] arr, int startIndex, int endIndex) {
        //对判断基准的取值使用随机数，避免碰到逆序数组的时候，时间复杂度退化成O（n^2)，而且这种情况还很容易导致栈溢出
        Random random = new Random();
        int index = startIndex + random.nextInt(endIndex - startIndex);
        swap(arr,startIndex,index);
        int key = arr[startIndex];
        int leftPt = startIndex;
        int rightPt = endIndex;

        while (leftPt != rightPt) {
            //移动右指针，找到下一个小于基准的元素
            while (leftPt < rightPt && arr[rightPt] >= key) {
                rightPt--;
            }

            //移动左指针，找到下一个大于基准的元素
            while (leftPt < rightPt && arr[leftPt] <= key) {
                leftPt++;
            }

            //交换左右指针指向的元素
            if (leftPt < rightPt) {
                Integer temp = arr[leftPt];
                arr[leftPt] = arr[rightPt];
                arr[rightPt] = temp;
            }
        }

        //交换leftPt和第一个元素
        Integer temp = arr[leftPt];
        arr[leftPt] = arr[startIndex];
        arr[startIndex] = temp;
        return leftPt;
    }
}
