package com.vi.algorithm.test;
import com.vi.algorithm.*;
import com.vi.algorithm.linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(5);
        //测试插入
        sl.insert("A");
        sl.insert("B");
        sl.insert("D");
        sl.insert(2,"C");
        sl.insert("E");
        sl.insert("F");
        System.out.println("size:"+sl.length());
        //测试获取
        for (int i = 0; i < sl.length(); i++) {
            System.out.println(sl.get(i));
        }
        //测试删除
        System.out.println(sl.remove(4));
        System.out.println("删除后:"+sl.get(4));
        System.out.println("size:"+sl.length());
        for (String str : sl) {
            System.out.println(str);
        }
        System.out.println("size:"+sl.length());

    }
}
