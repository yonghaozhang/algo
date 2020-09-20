package skiplist;

/**
 * 跳表中存储的是正整数，并且存储的不重复，已经从小到大排序。
 * @author toby Zhang
 * @date 2020-03-09 16:09
 * @description
 */
public class SkipList {


    private static final int MAX_LEVEL = 16;
    private static final float SKIPLIST_P = 0.5f; // 50%的概率阈值

    private Node head = new Node(); // 带头链表

    private int levelCount = 1; // 有几级索引， 1表示有1级索引


    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        // 循环后找到了离value 最近的 p 节点 的值。
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            // 节点就是要查询的节点
            return p.forwards[0];
        }
        return null;
    }


    /**
     * 插入一个值
     * @param value
     */
    public void insert(int value) {
        // 索引层数
        int level = randomLevel();
        Node  newNode = new Node();
        newNode.data = value;
        // 构建要插入的节点
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        //找到每一层最小的那个大于插入元素的的元素，放入update[i]
        for (int i = level -1; i >=0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // 上面找到的元素成为新节点的forward 元素。
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >=0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        // 如果删除的节点是索引层的唯一的节点，需要将索引层级减一。
        while (levelCount > 1 && head.forwards[levelCount] == null) {
            levelCount --;
        }
    }

    /**
     *  理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     *  因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     *  该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     *      50%的概率返回 1
     *      25%的概率返回 2
     *      12.5%的概率返回 3 ...
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }


    public class Node {
        private int data = -1; // 节点值
        private Node[] forwards = new Node[MAX_LEVEL]; // 当前节点在各个索引层的查询路径经过的节点的集合(每一层最大的那个小于插入元素的的元素)。
                                                       // 比如Node[0] 表示在原始层。
                                                       // Node[1] 表示在第一层索引层。
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}