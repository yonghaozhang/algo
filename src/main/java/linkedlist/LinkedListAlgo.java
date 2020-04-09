package linkedlist;

import common.Node;

/**
 *  1) 单链表反转
 *  2) 链表中环的检测
 *  3) 两个有序的链表合并
 *  4) 删除链表倒数第n个结点
 *  5) 求链表的中间结点
 * @author toby Zhang
 * @date 2020-01-14 16:53
 * @description
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     * @param list
     * @return 新的头结点
     */
    public Node reverse(Node list) {
        Node curr = list;
        Node pre = null;
        while (curr != null) {
            Node next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        return pre;
    }


    /**
     * 链表中是否有环
     * @param list
     * @return
     */
    public boolean hasCircle(Node list) {
        if (list == null) return false;
        Node fast = list.getNext();
        Node slow = list;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) return true;
        }
        return false;
    }


    /**
     * 删除倒数第K 个节点 （只循环一次）
     * @param list
     * @param k
     */
    public Node deleteLastKthNode(Node list, int k) {
        Node fast = list;
        int i = 1;
        // 快指针先移动k位
        while (fast != null && i < k) {
            fast = fast.getNext();
            i++;
        }
        if (fast == null) return list;

        Node slow = list;
        Node pre = null;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            pre = slow;
            slow = slow.getNext();

        }
        if (pre == null) {
            list = list.getNext();
        }else {
            pre.setNext(pre.getNext().getNext());
        }
        return list;
    }


    /**
     * 找出链表中间节点 (快慢指针法)
     * @param list
     * @return
     */
    public Node findMidNode(Node list) {
        if (list == null)  return null;
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }


}
