package com.snow.datastructure;

import java.util.Scanner;

/**
 * @author lurui
 * @Package com.snow.datastructure
 * @ClassName LinkedForLRU
 * @Description 基于链表实现最近最少使用算法
 * @Date 2020/2/6 10:55 下午
 */
public class LinkedForLRU<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LinkedForLRU() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LinkedForLRU(Integer capacity) {
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        Node preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(Node preNode) {
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        Node node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        Node ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        Node node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LinkedForLRU list = new LinkedForLRU();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
