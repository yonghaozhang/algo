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

    /**
     * 入栈
     * @param value
     * @return
     */
    public void push(int value) {
        Node n = new Node(value, null);
        if (top == null) {
            top = n;
        }else {
            n.next = top;
            top = n;
        }
        count++;
    }


    /**
     * 出站
     * @return
     */
    public int pop() {
        if (top == null) return -1;
        Node n = top;
        top = top.next;
        count--;
        return n.data;
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
