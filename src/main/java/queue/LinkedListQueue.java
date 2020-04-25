package queue;

import common.Node;

/**
 * @author toby Zhang
 * @date 2020-01-16 18:00
 * @description
 */
public class LinkedListQueue {

    private Node head; //头指针

    private Node tail; //尾指针


    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean enqueue(int item) {
        if (tail == null) {
            Node node = new Node(item, null);
            head = node;
            tail = node;
        }else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
        return true;
    }


    public int dequeue() {
        if (head == null) return -1; // 队列为空
        Node tmp = head;
        head = head.next;
        if (head == null) {
            tail = null;  // 队列只有一个元素
        }
        return tmp.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.getData()).append(",");
            node = node.getNext();
        }
        return sb.toString();
    }

}
