package linkedlist;

import common.Node;

/**
 * 单链表的 插入，查找，删除 操作
 * @author toby Zhang
 * @date 2020-01-14 09:28
 * @description
 */
public class SinglyLinkedList {

    private Node head;

    /**
     * 在头部插入一个节点
     * @param node
     */
    public void insert2Head(Node node) {
        if (head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }


    /**
     * 在头部插入一个值
     * @param value
     */
    public void insert2Head(int value) {
        Node node = new Node(value, null);
        this.insert2Head(node);
    }


    /**
     * 在尾部插入一个节点。
     * @param node
     */
    public void insert2Tail(Node node) {
        if (head == null) {
            head = node;
        }else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }


    /**
     * 在尾部插入一个值
     * @param value
     */
    public void insert2Tail(int value) {
        Node node = new Node(value, null);
        this.insert2Tail(node);
    }


    /**
     * 在节点p 后插入一个节点x
     * @param p
     * @param x
     */
    public void insertAfter(Node p, Node x) {
        if (p == null) return;
        x.next = p.next;
        p.next = x;
    }

    /**
     * 在节点p 后插入一个值value.
     * @param p
     * @param value
     */
    public void insertAfter(Node p , int value) {
        Node x = new Node(value, null);
        this.insertAfter(p, x);
    }

    /**
     * 在节点p 前插入一个节点x.
     * @param p
     * @param x
     */
    public void insertBefore(Node p, Node x) {
        if (p == null) return; // p定节点为空
        if (p == head) {
            // p节点为头结点
            this.insert2Head(x);
            return;
        }
        Node tmp = head;
        while (tmp != null && tmp.next != p) {
            tmp = tmp.next;
        }
        if (tmp == null) return;  //p节点在链表中不存在。

        x.next = p;
        tmp.next = x;
    }

    /**
     * 在节点p 前插入值 value
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node x = new Node(value, null);
        this.insertBefore(p, x);
    }

    /**
     * 根据值找节点
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node tmp = head;
        while (tmp != null && tmp.data != value) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 根据下标查找
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        int pos = 0;
        Node tmp = head;
        while (tmp !=null && pos < index) {
            tmp = tmp.next;
            pos++;
        }
        return tmp;
    }


    /**
     * 删除节点
     * @param x
     */
    public void deleteByNode(Node x) {
        if (head == null || x == null) return;
        Node tmp = head;
        while (tmp != null && tmp.next != x) {
            tmp = tmp.next;
        }
        if (tmp == null) return;
        tmp.next = tmp.next.next;
    }


    /**
     * 根据值删除找到的第一个节点
     * @param value
     */
    public void deleteFirstByValue(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = null;
            return;
        }
        Node tmp = head;
        while (tmp.next != null && tmp.next.data != value) {
            tmp = tmp.next;
        }

        if (tmp.next == null) return;
        tmp.next = tmp.next.next;
    }



    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder str = new StringBuilder();
        while (tmp != null) {
            str.append(tmp.data);
            tmp  = tmp.next;
        }
        return str.toString();
    }
}
