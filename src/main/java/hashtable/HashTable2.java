package hashtable;

import java.util.Arrays;

public class HashTable2<K, V> {

    private static final int DEFAULT_INITIAL_CAPATCITY = 8;

    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;

    private int size = 0; // 实际元素数量

    private int use = 0; // 散列表索引使用数量

    /**
     * constructor
     * @param size
     */
    public HashTable2(int size) {
        this.table =  new Entry[size];
    }

    /**
     * 插入一个元素
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = this.hash(key);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(key, value, null);
            size++;
            use++;
            if (use > table.length * LOAD_FACTOR) {
                // TODO: 2020/5/14 resize
            }
        }else {
            Entry<K, V> tmp = table[index];
            while (tmp.next != null) {
                tmp = tmp.next;
                if (tmp.key == key) {
                    return;
                }
            }
            Entry temp = table[index].next;
            table[index].next = new Entry<K, V>(key, value, temp);
            size++;
        }
    }

    public V get(K key) {
        int index = this.hash(key);
        Entry<K, V> e = table[index];
        if (e == null) {
            return null;
        }
        do {
            if (e.key == key) {
                return e.value;
            }
            e = e.next;
        }while (e.next != null);
        return null;
    }


    public void remove(K key) {
        int index = this.hash(key);
        Entry<K, V> e = table[index];
        if (e == null) {
            return;
        }
        if (e.key == key) {
            table[index] = null;
            use--;
            size--;
            return;
        }

        Entry pre;
        while (e.next != null) {
            pre = e;
            if (e.key == key) {
                pre.next = e.next;
                size--;
            }
            e = e.next;
        }
    }

    /**
     * 散列函数, 移位异或取余。
     * @return
     */
    private int hash(Object key) {
        int h = key.hashCode();
        return (key.hashCode() ^ (h >>> 16)) % table.length ;
    }

    class Entry<K,V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashTable2{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                ", use=" + use +
                '}';
    }
}
