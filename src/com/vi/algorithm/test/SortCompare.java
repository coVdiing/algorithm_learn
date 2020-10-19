package com.vi.algorithm.test;

import com.vi.algorithm.sort.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//比较插入排序和希尔排序的速度
public class SortCompare {
    public static void main(String[] args) throws IOException {
        Integer[] data = getArrayFromFile();
//        testBubble(data);
//        testInsertion(data);    //插入排序用时:37024毫秒
//        testShell(data);    //希尔排序用时:41毫秒
//        testMerge(data);    //希尔排序用时:153毫秒
        testQuick(data);    //快速排序用时:67毫秒
    }

    //从测试数据中读取数据转换成数组
    public static Integer[] getArrayFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./algorithm/reverse_order_array.txt"))));
        String line;
        ArrayList<Integer> data = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            data.add(Integer.parseInt(line));
        }
        Integer[] result = new Integer[data.size()];
        data.toArray(result);
        return result;
    }

    public static void testBubble(Integer[] arr) {
        Long start = System.currentTimeMillis();
        Bubble.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("冒泡排序用时:" + (end - start) + "毫秒");
    }

    public static void testInsertion(Integer[] arr) {
        Long start = System.currentTimeMillis();
        Insertion.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("插入排序用时:" + (end - start) + "毫秒");
    }

    public static void testShell(Integer[] arr) {
        Long start = System.currentTimeMillis();
        Shell.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("希尔排序用时:" + (end - start) + "毫秒");
    }

    public static void testMerge(Integer[] arr) {
        Long start = System.currentTimeMillis();
        Merge.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("希尔排序用时:" + (end - start) + "毫秒");
    }

    public static void testQuick(Integer[] arr) {
        Long start = System.currentTimeMillis();
        Quick.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("快速排序用时:" + (end - start) + "毫秒");
        for (Integer ele : arr) {
            System.out.println(ele);
        }
    }
}
