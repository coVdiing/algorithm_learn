package com.vi.algorithm.search;

/**
 * 插值查找算法
 */
public class InsertValueSearch {

    public static int search(int[] arr, int left, int right, int target) {
        System.out.println("查找一次");
        boolean notFindTarget = left > right || left < 0 || right > arr.length - 1;
        boolean outOfRange = target < arr[left] || target > arr[right];
        if (notFindTarget || outOfRange) {
            return -1;
        }
        // 通过比例估算目标值的下标位置，减少查找次数
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        if (target > arr[mid]) {
            return search(arr, mid + 1, right, target);
        }
        if (target < arr[mid]) {
            return search(arr, left, mid - 1, target);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 9, 14, 18, 22, 34, 47, 56, 67, 78, 89, 100, 101};
        System.out.println(search(arr, 0, arr.length - 1, 89));
    }
}
