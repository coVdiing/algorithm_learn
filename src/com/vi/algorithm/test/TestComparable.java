package com.vi.algorithm.test;


import com.vi.algorithm.entity.Student;

public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student("张三",20);
        Student s2 = new Student("李四", 25);
        System.out.println(getMax(s1,s2));
    }

    public static Comparable getMax(Comparable comparable1, Comparable comparable2) {
        return comparable1.compareTo(comparable2) >= 0 ? comparable1 : comparable2;
    }
}
