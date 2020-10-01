package com.vi.algorithm.test;

import com.vi.algorithm.linear.LinkList;

import java.util.Iterator;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> sl = new LinkList<>();
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
        Iterator it = sl.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("size:"+sl.length());
        //测试查找索引
        System.out.println("A的索引==>"+sl.indexOf("A"));
        System.out.println("a的索引==>"+sl.indexOf("a"));
        System.out.println("A的索引==>"+sl.indexOf("F"));
        sl.clear();
        System.out.println("遍历");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(sl.get(0));
    }
}
