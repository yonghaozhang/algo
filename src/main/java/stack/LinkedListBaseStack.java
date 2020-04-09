package stack;

import common.Node;
import lombok.extern.slf4j.Slf4j;

/**
 * 基于链表实现的栈，后进栈的元素放在链表头部。
 * @author toby Zhang
 * @date 2020-01-15 14:32
 * @description
 */
@Slf4j
public class LinkedListBaseStack {

    /**
     * 头结点
     */
    private Node top;

    /**
     * 栈当前的元素个数
     */
    private int count;


    public LinkedListBaseStack() {
    }

    /**
     * 入栈
     * @param value
     * @return
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        }else {
            newNode.setNext(top);
            top = newNode;
        }
        count++;
    }


    /**
     * 出站
     * @return
     */
    public int pop() {
        if (top == null) return -1;
        Node p = top;
        top = top.getNext();
        count--;
        return p.getData();
    }

    /**
     * 清空栈
     */
    public void clear() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public String toString() {
        Node p = top;
        StringBuilder s = new StringBuilder("");
        while (p != null) {
            s.append(p.getData()).append(",");
            p = p.getNext();
        }
        return s.toString();
    }

    public int getCount() {
        return count;
    }
}
