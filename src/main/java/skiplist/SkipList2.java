package skiplist;

import java.util.Arrays;

/**
 * 跳表中存贮的是正整数，并没有重复，已经从小到大排序。
 */
public class SkipList2 {

    private static final int MAX_LEVEL = 16; // 索引最大层数，0表示原始数据层， 1表示第一层索引。

    private Node head = new Node();

    private int levelCount = 1; // 当前跳表有几级索引， 1表示有1级索引

    /**
     * 在跳表中按值查询节点。
     * @return
     */
    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >=0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
        }
        // 循环后找到了离value 最近的 p 节点 的值。
        if (p.next[0] != null && p.next[0].data == value) {
            return p.next[0];
        }
        return null;
    }

    /**
     * 插入一个值
     * @param value
     */
    public void insert(int value) {
        // 索引层数
        int level = this.randomLevel();

        // 构建要插入的节点
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for(int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        //找到每一层最小的那个大于插入元素的的元素，放入update[i]
        for (int i = level-1; i >=0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            update[i] = p;
        }
        // 上面找到的元素成为新节点的forward 元素。
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if (this.levelCount < level) levelCount = level;


    }

    /**
     * 生成一个随机索引层数
     * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     * 50%的概率返回 1
     * 25%的概率返回 2
     * 12.5%的概率返回 3 ...
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < 0.5f && level < MAX_LEVEL) {
            level+=1;
        }
        return level;
    }




    class Node {
        private int data = -1; //节点值
        private Node[] next = new Node[MAX_LEVEL]; // 当前节点在各个索引层的查询路径经过的节点的集合(每一层最大的那个小于插入元素的的元素)。
                                                        // 比如Node[0] 表示在原始层。
                                                        // Node[1] 表示在第一层索引层。
        private int maxLevel = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + Arrays.toString(next) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p.next[0] != null) {
            sb.append(p.data).append("-->");
            p = p.next[0];
        }
        return sb.toString();
    }

}
