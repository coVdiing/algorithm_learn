package com.vi.algorithm.linear;

import java.util.Arrays;
import java.util.Iterator;

//线性表实现
public class SequenceList<T> implements Iterable<T> {
    T[] element;
    //当前数组中有效元素数量
    int size;

    public SequenceList(int size) {
        element = (T[]) new Object[size];
        size = 0;
    }

    //清空表中内容
    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

    //是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获取元素个数
    public int length() {
        return size;
    }

    //获取第i个值
    public T get(int i) {
        return element[i];
    }

    //在i索引处插入t
    public void insert(int i, T t) {
        if (size + 1 > element.length) {
            resize();
        }
        for (int j = size - 1; j >= i; j--) {
            element[j + 1] = element[j];
        }
        element[i] = t;
        size++;
    }

    public void insert(T t) {
        insert(size, t);
    }

    //删除并返回线性表中第i个数据
    public T remove(int i) {
        T result = element[i];
        if (i == size - 1) {
            element[i] = null;
            size--;
            return result;
        }
        for (int j = i; j < size - 1; j++) {
            element[j] = element[j + 1];
        }
        size--;
        return result;
    }

    //扩容方法
    public void resize() {
        int oldLength = element.length;
        int newLength = (int) (element.length * 1.5);
        T[] newElement = (T[]) new Object[newLength];
        newElement = Arrays.copyOf(element, newLength);
        element = newElement;
    }

    // 返回线性表中首次出现的指定的元素的序号，如果不存在返回-1
    public int indexOf(T t) {
        int i;
        for (i = 0; i < size; i++) {
            if (element[i].equals(t))
                break;
        }
        return i;
    }

    // 实现Iterable接口
    @Override
    public Iterator<T> iterator() {
        return new Ite();
    }

    public class Ite implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor + 1 < size;
        }

        @Override
        public T next() {
            return element[cursor++];
        }
    }

}
