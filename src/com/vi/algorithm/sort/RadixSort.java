package com.vi.algorithm.sort;

//  基数排序
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214,57,88,73,24,99,11,111,222,23423,1438};
        int[] arr = new int[1000000];
        for (int i = 0,j = 1000000; i < 1000000; i++,j--) {
            arr[i] = j;
        }
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("用时:"+(end-start)+"ms");
    }


    private static void sort(int[] arr) {
        //  首先遍历一次数组，找出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        //  获得最大值的长度，这个值会决定需要进行几轮排序
        int maxLength = (max + "").length();
        //  准备10个桶存放数据,用二维数组bucket[][]表示,bucket[0]表示所有基数为0的数,bucket[1]表示所有基数为1的数,依次递推...
        int[][] bucket = new int[10][arr.length];
        //  准备一个一维数组来记录每个桶里存放了几个数据
        int[] bucketLength = new int[10];
        //  maxLength排序
        for (int i = 0, n = 1; i < maxLength; i++, n = n * 10) {
            //  遍历数组
            for (int j = 0; j < arr.length; j++) {
                //  第1轮取个位基数，第2轮取百位基数...递推
                int base = arr[j] / n % 10;
                //  把数据存入对应的桶中
                bucket[base][bucketLength[base]] = arr[j];
                bucketLength[base]++;
            }

            int index = 0;
            //  将桶中数据依次写回到数组中
            for (int j = 0; j < 10; j++) {
               if(bucketLength[j] == 0)
                   continue;
                for (int jj = 0; jj < bucketLength[j]; jj++) {
                    arr[index++] = bucket[j][jj];
                }
                //  清空bucketLength中的记录
                bucketLength[j] = 0;
            }
        }
    }
}
