package com.vi.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: vi
 * @Date: 2021-05-23 13:49
 * @Version: 1.0
 * @Description:
 */
public class Leetcode4 {
    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        Leetcode4 lc = new Leetcode4();
        System.out.println(lc.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int indexTotal = 0;
        while (indexTotal < total.length) {
            // 两个数组都没遍历完的情况
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] < nums2[index2]) {
                    total[indexTotal++] = nums1[index1++];
                } else {
                    total[indexTotal++] = nums2[index2++];
                }
            } else if (index1 < nums1.length) {
                // nums1没遍历完的情况
                System.arraycopy(nums1, index1, total, indexTotal, nums1.length - index1);
                break;
            } else {
                // nums2没遍历完的情况
                System.arraycopy(nums2, index2, total, indexTotal, nums2.length - index2);
                break;
            }
        }
        int num = total.length / 2;
        for (int i = 0; i < total.length; i++) {
            System.out.println(total[i]);
        }
        // 判断长度是奇数还是偶数
        if (total.length % 2 == 0) {
            return (double) (total[num] + total[num - 1]) / 2;
        } else {
           return ((double) total[num]);
        }
    }
}
