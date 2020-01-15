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


    public void insert2Tail(Node node) {
        if (head == null) {
            head = node;
        }else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = node;
        }
    }


    /**
     * 在尾部插入一个值
     * @param value
     */
    public void insert2Tail(int value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        }else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = node;
        }
    }


    /**
     * 在节点p 后插入一个节点x
     * @param p
     * @param x
     */
    public void insertAfter(Node p, Node x) {
        if (p == null) {
            p.next = x;
        }else {
            x.next = p.next;
            p.next = x;
        }
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
        if (p == null) return;
        if (p == head) {
            this.insert2Head(x);
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = x;
        x.next = p;
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
        Node p = head;
        while (p !=null && value != p.data) {
            p = p.next;
        }
        return p;
    }


    /**
     * 根据下标查找
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }


    /**
     * 删除节点
     * @param x
     */
    public void deleteByNode(Node x) {
        Node p = head;

        if (p == null || x == null) return;

        if (x == head) head = head.next;

        while (p != null && p.next != x) {
            p = p.next;
        }

        if (p == null) return;

        p.next = p.next.next;
    }

    /**
     * 根据值删除找到的第一个节点
     * @param value
     */
    public void deleteFirstByValue(int value) {
        if (head == null) return;

        if (value == head.data) {
            head = null;
        }
        Node p = head;
        while (p!= null && value != p.next.data) {
            p = p.next;
        }
        if (p == null) return;

        p.next = p.next.next;
    }


    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
