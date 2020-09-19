package heap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author toby Zhang
 * @date 2020-03-24 11:16
 * @description
 */
public class Heap {

    private int[] a; // 数组，从下标1开始存储
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中元素的个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 往大顶堆中插入一个元素
     * @param data -
     */
    public void insert(int data) {
        if (count > n) return; // 堆满了,
        a[++count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化。 插入值>他的父节点值时候，交换位置。直到下标0。
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
        heapify(a, count, 1);
    }

    /**
     * 堆排序。n表示数据的个数，数组a中的数据从下标1到n的位置
     * @param a
     * @param n
     */
    public void sort(int a[], int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    /**
     * 对任意i节点进行从上往下的大顶堆堆化。
     * @param a - 数组
     * @param n - 堆中元素的个数
     * @param i - 待堆化元素在数组中的位置
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2])
                maxPos = i * 2; // 当节点值 < 左子节点值，修改最大节点位置maxPos
            if (i*2+1  <=n && a[maxPos] < a[i*2+1])
                maxPos = i*2+1; // 节点值(左节点值) < 右节点值 修改最大节点位置maxPos
            if (maxPos == i)
                break; // 当前位置i 的值比左右子节点的值都大，退出循环,结束堆化
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) { //我们对下标从 n/2​ 开始到 1 的数据进行堆化，下标是 n/2​+1 到 n 的节点是叶子节点，我们不需要堆化
            heapify(a, n, i);
        }
    }


}
