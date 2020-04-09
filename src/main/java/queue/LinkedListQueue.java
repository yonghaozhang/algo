package queue;

import common.Node;

/**
 * @author toby Zhang
 * @date 2020-01-16 18:00
 * @description
 */
public class LinkedListQueue {

    private Node head;

    private Node tail;


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
            tail.setNext(new Node(item, null));
            tail = tail.getNext();
        }
        return true;
    }


    public int dequeue() {
        if (head == null) return -1;
        int item = head.getData();
        head = head.getNext();
        if (head == null) tail = null;
        return item;
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
