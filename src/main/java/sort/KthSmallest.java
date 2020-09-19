package sort;

public class KthSmallest {

    /**
     * 查找数组中第k小的元素。
     * @param a
     * @param k
     * @return
     */
    public int sort(int[] a, int k) {
        if (a == null || a.length < k) return -1;
        int q = this.partition(a, 0, a.length-1);

        while (q + 1 != k) {
            if (q + 1 > k) {
                q = this.partition(a, 0, q-1);
            }else if (q+1 < k) {
                q= this.partition(a, q+1, a.length-1);
            }
        }
        return a[q];
    }

    private int partition(int[] a, int p, int r) {
        int pivotValue = a[r];
        int pivotIndex = p;
        for (int i = p; i < r; i++) {
            if (a[i] <= pivotValue) {              // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
                if (i == pivotIndex) {
                    pivotIndex++;
                }else {
                    int tmp = a[i];
                    a[pivotIndex++] = a[i];
                    a[i] = tmp;
                }
            }
        }

        int tmp = a[r];
        a[r] = a[pivotIndex];
        a[pivotIndex] = tmp;

        return pivotIndex;
    }
}
