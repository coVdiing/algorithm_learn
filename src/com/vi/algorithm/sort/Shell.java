package com.vi.algorithm.sort;

//希尔排序，在插入排序的基础上优化，按照增长量将数据进行分组，假设增长量为h，i和i+h为同一组
public class Shell {

    public static void sort(Comparable[] arr) {
        //定义希尔排序的增长量
        int h = 1;
        //计算增长量
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }

        while (h >= 1) {    //当增长量小于1的时候，结束循环
            //每一轮假定索引h之前是有序区域，从h开始分组进行比较
            for (int i = h; i < arr.length; i++) {
                //同组数据进行比较，若有序不做任何动作,若无序需要和前面元素逐一比较
                for(int j = i ; j >= h ; j = j - h) {
                    if (greater(arr[j-h], arr[j])) {
                        swap(arr, j, j-h);
                    } else {
                        break;
                    }
                }
            }
            //减少增长量
            h = h / 2;
        }
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
