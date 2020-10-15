package heap;

public class Heap4Learning {

    int[] a;
    int n = 10;
    int count = 0;

    void insert(int value) {
        // 将元素放到堆的最末尾
        if (count == capacity) return;
        a[++count] = value;
        // 自下向上堆化:比较插入值(i)和父节点大小(i/2)，如果大于父节点的值，和父节点交换位置。

        int i = count;
        while(a[i] > a[i/2]) {
            swap(a, 2/i, i);
            i = 2/i;
        }
    }

    void removeMax() {
        // 当前堆元素为空，返回
        if (count == 0 ) return;
        // 自上向下堆化，比较父节点和左子节点的大小，再和右节点比较，如果比左右节点都达，堆化结束。反之，和左右节点中最大的那个节点互换位置。
        a[1] = a[count];

        int i = a[1];
        while(true) {
            int maxPos = i;
            if(a[i] < a[i*2] && i*2 < n) {
                maxPos = i*2;
            }else if(a[maxPos] < a[i*2+1] && i*2+1 < n) {
                maxPos = i*2+1;
            }else {
                return;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }




}
