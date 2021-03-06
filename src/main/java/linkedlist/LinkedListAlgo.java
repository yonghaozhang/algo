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
        Node pre = null;
        Node curr = list; // 正序链表某个节点的前驱节点
        while (curr != null) {
            //让当前节点(curr)的下一个节点指向前驱节点(prev), 然后把pre指向当前节点，当前节点的指向next.

            //先把当前节点的下个节点记录下来, 将next和pre节点换位
            Node next = curr.next; //先把当前节点的下个节点记录下来, 将next和pre节点换位
            curr.next = pre;
            pre = curr; // 前一个节点 指向当前节点
            curr = next; // 当前节点指向下一个节点
        }
        return pre;
    }


    /**
     * 通过快慢指针，慢指针每次一步，快指针每次2步，(1)当快指针为空或者快指针下一个节点为空时，表示链表没有换， 在(1)情况出现前快慢指针相遇时，表示链表中是否有环。
     * @param list
     * @return
     */
    public boolean hasCircle(Node list) {
        if (list == null) return false;
        Node slow = list;
        Node fast = list.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
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
        // 快指针先移动k-1位
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (fast == null) return list; // 链表为空，或者链表没有k个元素。

        Node slow = list;
        Node slowPre = null;

        while (fast.next != null) {
            fast = fast.next;
            slowPre = slow;
            slow = slow.next;
        }

        if (slowPre == null) {
            // 倒数第k个节点就是第一个节点的时候。
            return list.next;
        }else {
            slowPre.next = slowPre.next.next; // 删除第k个节点
        }
        return list;
    }


    /**
     * 找出链表中间节点 (快慢指针法)
     * @param list
     * @return
     */
    public Node findMidNode(Node list) {
        Node fast = list;
        Node slow = list;
        if (list == null) return null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
