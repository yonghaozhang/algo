package linkedlist;

import common.Node;

public class LinkedListAlgoLearning {

    Node reverse(Node list) {

        // node1 -> node2
        // node1 <- node2
        // node1 <- node2
        Node pre = null; // 正序链表某个节点的前驱节点
        Node curr = list;
        while (curr != null) {
            Node next = curr.next; //先把当前节点的下个节点记录下来, 将next和pre节点换位
            curr.next = pre; // 当前节点的下个节点指向前驱节点
            pre = curr; // 前驱节点指向当前节点
            curr = next; // 当前节点选取下坡个节点
        }
        return pre;
    }


    boolean hasCircle(Node list) {
        if (list ==null || list.next == null) return false;
        Node fast = list.next;
        Node slow = list;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    Node deleteLastKthNode(Node list, int k) {
        //先让快指针走k-1位
        Node fast = list;
        int i=1;
        while (fast!= null && i<k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) return null;
        // 慢指针和快指针一起走，知道快指针走到末尾
        Node slow = list;
        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



}
