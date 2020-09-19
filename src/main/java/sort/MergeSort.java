package sort;

/**
 * @author toby Zhang
 * @date 2020-01-20 17:05
 * @description
 */
public class MergeSort implements ISort {

    public void sort(int[] a) {
        this.mergeSortInternally(a, 0, a.length-1);
    }

    public void sort(int[] a, int n) {
        // TODO: 2020/4/29  
    }


    /**
     * 递归调用函数。
     * @param a
     * @param p
     * @param r
     */
    private void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) return;  // 递归公式终止条件。
        int q = p + (r - p)/2; // 取 p 到 r 之间的位置，防止 （p+r）的和超出 int 类型的最大值。
        this.mergeSortInternally(a, p, q);
        this.mergeSortInternally(a, q+1, r);
        this.merge(a, p, q, r); // 将分治的数组合并成一个数组。
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
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r] 一样的临时数组， 存放合并后的数组。
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) { // <= 保证稳定排序
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个数组中有剩余的数据。
        int start = i; // 剩余元素的开始位置
        int end = q; // 剩余元素的结束位置
        if (j <= r) { // 右边的数组有剩余元素
            start = j;
            end = r;
        }
        // 将剩余元素copy到临时数组tmp
        while (start<=end) {
            tmp[k++] = a[start++];
        }
        //将tmp 中的元素copy 到 a[p,r];
        for (int l=0; l<= r-p; l++) {
            a[p+l] = tmp[l];
        }
    }
}
