package com.vi.algorithm.linear;
//  双向链表
public class TwowayLinkList<T> {
    //  头节点，用于链表导航
    Node<T> head;
    //  尾节点，指向最后一个元素
    Node<T> last;
    //  链表长度，不包含头结点
    int size;

    //  内部类，Node节点
    private class Node<T> {
        T data;
        //  指向上个节点
        Node pre;
        //  指向下个节点
        Node next;

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre  = pre;
            this.next = next;
        }
    }

    public TwowayLinkList() {
        head = new Node(null, null, null);
        size = 0;
    }

    //  置空链表
    public void clear() {
        head.next = null;
        last = null;
        size = 0;
    }

    //  判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //  获取元素个数
    public int size() {
        return size;
    }

    //  获取表中索引i处的元素,i取值从0到size-1
    public T get(int i) {
        //  判断链表是否为空，输入是否合法
        if (isEmpty() || i < 0  || i >= size) {
            throw new RuntimeException("链表为空，下标越界");
        }

        Node<T> current = head;

        for (int index = 0; index <= i; index++) {
            //  链表不为空，判断下标是否越界
            if (current.next == null) {
                throw new RuntimeException("下标越界");
            }
            current = current.next;
        }
        //  循环遍历完，current指向索引i处的元素
        return current.data;
    }

    //  向表中添加一个元素
    public void insert(T t) {
        //  判断链表是否为空
        if(isEmpty()) {
            //  空表插入，将新节点链到头结点后面，赋值给尾节点
            Node newNode = new Node(t, head, null);
            head.next = newNode;
            last = newNode;
        } else {
            //  如果链表不为空，在尾节点处新增一个节点，把当前尾节点的next指向新节点，再让新节点成为尾结点
            Node newNode = new Node(t, last, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //  在表中索引i之前插入一个元素
    public void insert(int i, T t) {
        //  判断输入是否合法
        if (i < 0 || i > size-1) {
            throw new RuntimeException("下标越界");
        }
        Node current = head;
        if (isEmpty()) {   //  如果当前链表为空，调之前写的insert方法插入即可
            insert(t);
        } else {
            for (int index = 0; index < i; index++) {
                current = current.next;
            }
            //  遍历结束，current指向i-1元素处,让current的next下标指向新元素
            Node oldNext = current.next;
            Node newNode = new Node(t, current, oldNext);
            current.next = newNode;
            //  判断oldNext是否为空，如果不为空，就把oldNext的pre指向新元素
            if (oldNext != null)
                oldNext.pre = newNode;
        }
        size++;
    }

    //  删除并返回表中第i个数据
    public T remove(int i) {
        //  判断链表是否为空，输入是否合法
        if (isEmpty() || i < 0 || i > size - 1) {
            throw new RuntimeException("下标越界");
        }
        //  判断是否尾节点
        if (i == size - 1) {

        }
        Node<T> current = head;
        //  让current指向i-1处
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        Node<T> waitRemove = current.next;
        //  把current和waitRemove.next连接起来
        current.next = waitRemove.next;
        if (waitRemove.next != null)
            waitRemove.next.pre = current;
        size--;
        return waitRemove.data;
    }

    //  返回元素第一次出现的位置，如果不存在返回-1
    public int indexOf(T t) {
        if (isEmpty()) {
            throw new RuntimeException("下标越界");
        }
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current.data.equals(t) && current.data.hashCode() == t.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    //  返回第一个元素
    public T getFirst() {
        if (isEmpty())
            return null;

        return (T) head.next.data;
    }

    //  返回最后一个元素
    public T getLast() {
        return (T) last.data;
    }
}
