package linkedlist;

/**
 * 基于单链表的LRU 缓存的实现
 * @author toby Zhang
 * @date 2020-01-13 09:43
 * @description
 */
public class LinkedListBaseLRU<T> {

    /**
     * 头结点
     */
    private SNode headNode;

    /**
     * 链表已使用长度
     */
    private int count;

    /**
     * 链表允许存放的总长度
     */
    private int capacity;


    public LinkedListBaseLRU(int capacity) {
        this.headNode = new SNode();
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 模拟访问某个缓存
     * @param data
     */
    public void add(T data) {
        SNode preNode = this.findPreNode(data);

        if (preNode != null) {
            //链表中存在要插入的数据，删除原数据，再插入链表头部。
            this.deleteNextNode(preNode);
            this.insertElementAtHead(data);
        }else {
            if (count >= capacity) {
                // 链表已满
                this.deleteElmAtEnd();
            }
            // 在链表头部插入元素
            this.insertElementAtHead(data);
        }
    }


    /**
     * 获取要查找元素的上一个节点
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = this.headNode;
        while (node.next != null) {
            Object element = node.next.element;
            if (element.equals(data)) {
                return node;
            }else {
                node = node.next;
            }
        }
        return null;
    }


    /**
     * 删除链表的尾部节点。
     */
    private void deleteElmAtEnd() {
        SNode node = this.headNode;
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        count--;
    }


    /**
     * 删除preNode节点的下一个节点
     * @param preNode
     */
    private void deleteNextNode(SNode preNode) {
        if (preNode.next == null) return;
        preNode.next = preNode.next.next;
        count--;
    }


    /**
     * 在链表同头部插入节点。
     * @param data
     */
    private void insertElementAtHead(T data) {
        SNode next = headNode.next;
        headNode.setNext(new SNode(data, next));
        count++;
    }


    class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        return "LinkedListBaseLRU{" +
                "headNode=" + headNode +
                ", count=" + count +
                ", capacity=" + capacity +
                '}';
    }
}
