package sort;

/**
 * 冒泡排序
 * @author toby Zhang
 * @date 2020-01-19 14:18
 * @description
 */
public class BubbleSort {

    /**
     *
     * @param a 数组
     * @param n 数组大小
     */
    public void sortAsASC(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
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
