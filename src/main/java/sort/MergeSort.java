package sort;

/**
 * @author toby Zhang
 * @date 2020-01-20 17:05
 * @description
 */
public class MergeSort {

    public void mergeSort(int[] a) {

    }


    private void mergeSortInternally(int[] a, int p, int r) {
        if (p > r) return;
        int q = p + (r - p)/2; // 取 p 到 r 之间的位置，防止 （p+r）的和超出 int 类型的最大值。

        this.mergeSortInternally(a, p, q);
        this.mergeSortInternally(a, q+1, r);

        this.merge(a, p, q, r);
    }

    /**
     * 将a[p..q], a[q+1 ... r] 合并成 a[p...r]
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private void merge(int a[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r] 一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }

    }
}
