package hashtable;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 散列表实现
 * @author toby Zhang
 * @date 2020-03-11 16:13
 * @description
 */
public class HashTable<K, V> {

    private static final int DEFAULT_INITAL_CAPACITY = 8; //  散列表默认长度。

    private static final float LOAD_FACTOR = 0.75f; // 装载因子阈值，扩容使用。

    private Entry<K, V>[] table;  // 初始化散列表数组

    private int size = 0; // 实际元素数量

    private int use = 0; // 散列表应用数量

    /**
     * constructor
     */
    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    /**
     * 向hashtable 中增加元素。
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = this.hash(key);
        // 位置未被占用，创建哨兵节点。
        if (table[index] == null){
            table[index] = new Entry<K, V>(null, null, null);
        }

        Entry<K, V> tmp = table[index];
        if (tmp.next == null) {
            // 新增节点
            tmp.next = new Entry<K, V>(key, value, null);
            size++;
            use++;
            // 动态扩容
            if (use >= table.length * LOAD_FACTOR) {
                this.resize();
            }
        }else {
            //解决散列冲突
            do {
                tmp = tmp.next;
                // key 相同，覆盖旧的数据
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            }while (tmp.next != null);

            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<K, V>(key, value, temp); // 将冲突元素放到链表头部
            size++;
        }
    }

    public void remove(K key) {
        // TODO: 2020-03-11
        int index = this.hash(key);
        Entry e = table[index];
        if (e == null || e.next == null) {
            return;
        }
        Entry pre;
        Entry<K,V> headNode = table[index];
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if (headNode.next == null) use--;
                return;
            }
        }while (e.next != null);
        LinkedHashMap map = new LinkedHashMap<Integer, Integer>();
    }

    /**
     * 查询
     * @param key
     * @return
     */
    public V get(K key) {
        int index = this.hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }
        while (e.next != null) {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        }
        return null;
    }

    /**
     * hash 函数
     * @param key
     * @return
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    /**
     *
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2]; // 扩容大小是原来的两倍
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key); // 根据扩容后的大小重新对所元素进行hash。
                if (table[index] == null) {
                    use++;
                    //
                    table[index] = new Entry<K, V>(null, null, null);
                }
                table[index].next = new Entry<K, V>(e.key, e.value, table[index].next);
            }
        }
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // 链表解决散列冲突
        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
