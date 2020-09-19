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
            //从未排序组中找到最小的元素的位置
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex]; //放到排序区里，就是和未排序区第一个元素交换位置。
            a[minIndex] = tmp;
        }
    }
}
