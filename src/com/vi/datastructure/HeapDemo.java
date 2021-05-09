package com.vi.datastructure;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array,2);
        System.out.println(Arrays.toString(array));
    }

    public static void upAdjust(int[] arr) {
        int child = arr.length - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && arr[parent] > arr[child]) {
            int temp = arr[parent];
            arr[parent] = arr[child];
            arr[child] = temp;
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public static void downAdjust(int[] arr, int index) {
        int parent = index;
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;
        while (rightChild < arr.length) {
            if (arr[leftChild] < arr[rightChild]) {
                if (arr[parent] < arr[leftChild]) {
                    break;
                } else {
                    int temp = arr[parent];
                    arr[parent] = arr[leftChild];
                    arr[leftChild] = temp;
                    parent = leftChild;
                    leftChild = 2 * parent + 1;
                    rightChild = 2 * parent + 2;
                }
            } else {
                if (arr[parent] < arr[rightChild]) {
                    break;
                } else {
                    int temp = arr[parent];
                    arr[parent] = arr[rightChild];
                    arr[rightChild] = temp;
                    parent = rightChild;
                    leftChild = 2 * parent + 1;
                    rightChild = 2 * parent + 2;
                }
            }
        }
    }

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr,i);
        }
    }

    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] arr, int mode) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr,i,arr.length);
        }
    }

}
