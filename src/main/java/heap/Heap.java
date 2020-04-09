package heap;

/**
 * @author toby Zhang
 * @date 2020-03-24 11:16
 * @description
 */
public class Heap {

    private int[] a; // 数组，从下标1开始存储
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 往堆中插入一个元素
     * @param data
     */
    public void insert(int data) {
        if (count > n) return; // 堆满了
        a[++count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a,  i, i/2);
            i = i/2;
        }
    }

    /**
     * 从堆中移除一个元素
     */
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        count--;


    }

    /**
     * 从上往下堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i * 2; // 节点 值 < 左子节点值
            if (i*2+1  <=n && a[maxPos] < a[i*2+1]) maxPos = i*2+1; // 节点值(左节点值) < 右节点值
            if (maxPos == i) break; // 当前位置i 的值比左右子节点的值都大，退出循环
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
}
