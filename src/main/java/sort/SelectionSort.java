package sort;

/**
 * @author toby Zhang
 * @date 2020-01-20 10:05
 * @description
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param a
     */
    public void sort(int[] a) {
        if (a.length <= 1) return;
        for (int i = 0; i < a.length - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }
}
