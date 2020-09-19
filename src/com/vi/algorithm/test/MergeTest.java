package com.vi.algorithm.test;

import com.vi.algorithm.sort.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {9, 2, 0, 7, 5, 4, 6, 2, 1, 3,-1,11,22,100,38};
        Integer[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
