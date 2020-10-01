package com.vi.algorithm.test;

import com.vi.algorithm.linear.TwowayLinkList;

public class TwowayLinkListTest {
    public static void main(String[] args) {
        TwowayLinkList<String> list = new TwowayLinkList();
        System.out.println("第一个元素:"+list.getFirst());
        list.insert("海贼王");
        list.insert("火影忍者");
        list.insert("死神");
        list.insert("妖精的尾巴");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"===>"+list.get(i));
        }
        System.out.println("第一个元素:"+list.getFirst());

        System.out.println("====================");

        list.insert(0,"钢炼");
        list.insert(2, "强风吹拂");
        list.insert(5, "进击的巨人");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"===>"+list.get(i));
        }
        System.out.println("====================");

        list.remove(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"===>"+list.get(i));
        }

        System.out.println("====================");
        list.remove(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"===>"+list.get(i));
        }

        System.out.println("====================");
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+"===>"+list.get(i));
        }

        System.out.println("====================");
        System.out.println(list.indexOf("说3432"));
        System.out.println("最后一个元素:"+list.getLast());


    }
}
