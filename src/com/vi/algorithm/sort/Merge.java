package com.vi.algorithm.sort;

//归并排序，递归方式实现
public class Merge {
    //对外暴露的排序方法
    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

    //将数组arr从下标low到下标high进行排序
    private static void sort(Comparable[] arr, Integer low, Integer high) {
        if (low >= high) {
            //递归边界条件,将大数组分成只有一个元素的小数组时不再分组
            return;
        }
        Integer mid = low + (high - low)/2;

        sort(arr, low, mid);
        sort(arr, mid + 1, high);

        //将分组归并排序
        merge(arr, low, mid, high);
    }

    //真正的排序在这个方法里实现
    private static void merge(Comparable[] arr, Integer low, Integer mid, Integer high) {
        //定义三个指针，分别指向左边分组，右边分组，以及辅助用的临时数组
        Integer leftpt = low;
        Integer rightpt = mid+1;
        Integer temppt = 0;
        //定义临时数组
        Comparable[] temp = new Comparable[high - low + 1];

        //当两个指针都没有遍历完
        while (leftpt <= mid && rightpt <= high) {
            if (less(arr[leftpt], arr[rightpt])) {
                //左边指针指向的元素比较小时，存进临时数组
                temp[temppt++] = arr[leftpt++];
            } else {
                temp[temppt++] = arr[rightpt++];
            }
        }

        //上边的循环跳出以后，左右指针总有一个还没有遍历完，下面两个while循环只有一个会执行
        while (leftpt <= mid) {
            temp[temppt++] = arr[leftpt++];
        }

        while (rightpt <= high) {
            temp[temppt++] = arr[rightpt++];
        }

        //把辅助数组中的元素拷贝到原数组中
        for (int i = low,j = 0; i <= high && j<temp.length; i++) {
            arr[i] = temp[j++];
        }
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) <= 0;
    }
}
