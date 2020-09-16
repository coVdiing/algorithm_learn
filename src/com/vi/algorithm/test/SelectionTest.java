package com.vi.algorithm.test;

import com.vi.algorithm.sort.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {9, 2, 3, 7, 5, 4, 6, 2, 1, 3};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
    }
}
