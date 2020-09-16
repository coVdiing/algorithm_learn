package com.vi.algorithm.test;

import com.vi.algorithm.sort.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {9, 2, 3, 7, 5, 4, 6, 2, 1, 3};
        Bubble bubble = new Bubble();
        bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
