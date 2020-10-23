package com.vi.algorithm.search;

//  二分查找法
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 11, 15, 22, 27, 33, 48, 50, 101};
        System.out.println(search(arr,101));
    }

    private static int search(int[] arr,int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    private static int binarySearch(int[] arr, int left, int right,int target) {
        if(left > right)
            //  如果左下标大于右下标，说明没找到返回-1
            return -1;
        int mid = (left + right) / 2;
        if (target > arr[mid]) {
            //  目标在右半区，递归右半区
            return binarySearch(arr,mid + 1, right,target);
        } else if (target < arr[mid]) {
            //  目标在左半区，递归左半区
            return binarySearch(arr, right, mid - 1, target);
        } else
            return mid;
    }
}
