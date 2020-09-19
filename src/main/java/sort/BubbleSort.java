package sort;

/**
 * 冒泡排序
 * @author toby Zhang
 * @date 2020-01-19 14:18
 * @description
 */
public class BubbleSort {

    public void sortAsASC(int[] a) {
        if (a.length <= 1) return;
        for (int i = 0; i < a.length; i++) {
            boolean sorted = true; // 如果某一次冒泡，发现数据都在合适位置上，表示所有数据都已经排序好了，则不需要再排序
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j+1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }


    /**
     * 冒泡排序法改进：在每一轮排序后记录最后一次元素交换的位置，把这个位置作为下次比较的边界。
     * @param a
     * @param n
     */
    public void sortAsASC2(int[] a, int n) {
        if (n <= 1) return;
        int border = n - 1;
        int lastChange = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < border; j ++){
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = tmp;
                    flag = true;
                    lastChange = j;
                }
            }
            border = lastChange;
            if (!flag) return;
        }
    }


}
