package com.vi.algorithm.linear;

import java.util.Iterator;

/**
 * 单向链表
 */
public class LinkList<T> implements Iterable<T> {
    // 头结点
    private Node head;
    // 链表长度
    private int length;

    public LinkList() {
        head = new Node(null, null);
        length = 0;
    }

    // 内部类，节点类型
    private class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    // 清空链表
    public void clear() {
        if (head == null)
            return;
        head.next = null;
        length = 0;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    // 获取链表中元素的个数
    public int length() {
        return length;
    }

    // 获取第i个元素的值
    public T get(int i) {
        if (head == null)
            return null;
        Node cursor = head;
        for (int index = 0; index <= i; index++) {
            if (cursor.next != null)
                cursor = cursor.next;
            else
                throw new RuntimeException("下标越界");
        }
        return (T) cursor.data;
    }

    // 在链表索引i处插入元素t
    public void insert(int i, T t) {
        if (head == null)
            return;
        Node cursor = head;

        int index = 0;
        while (index <= i - 1) {
            if (cursor != null) {
                cursor = cursor.next;
            } else
                throw new RuntimeException("下标越界");
            index++;
        }

        if (cursor != null) {
            if (cursor.next != null) {
                Node newNode = new Node(t, cursor.next);
                cursor.next = newNode;
            } else {
                Node newNode = new Node(t, null);
                cursor.next = newNode;
            }
            length++;
        }
    }

    // 在链表最后的位置插入一个元素
    public void insert(T t) {
        if (head == null)
            return;

        insert(length, t);
    }

    // 删除链表中索引i处的元素并返回
    public T remove(int i) {
        if (head == null)
            return null;
        Node cursor = head;
        for (int index = 0; index <= i - 1; index++) {
            if (cursor.next == null)
                throw new RuntimeException("下标越界");
            cursor = cursor.next;
        }

        if (cursor.next == null) {
            return null;
        } else {
            Node target = cursor.next;
            Node next = target.next;
            cursor.next = next;
            target.next = null;
            length--;
            return (T) target.data;
        }
    }

    // 查找t在链表中的索引位置，如果不存在返回-1
    public int indexOf(T t) {
        Node cursor = head.next;
        int index = 0;
        while (cursor != null) {
            if (cursor.data.equals(t)) {
                return index;
            }
            index++;
            cursor = cursor.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Literator();
    }

    private class Literator implements Iterator {
        Node cursor;

        public Literator() {
            cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Object next() {
            cursor = cursor.next;
            return cursor;
        }
    }
}
