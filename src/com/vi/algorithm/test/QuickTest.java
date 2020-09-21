package com.vi.algorithm.test;

import com.vi.algorithm.sort.Quick;
import com.vi.algorithm.sort.Quick2;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {12,11,10,9,8,7,6,5,5,4,3,2,1,0,-1,12,11,10,9,8,7,6,5,5,4,3,2,1,0,-1};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
