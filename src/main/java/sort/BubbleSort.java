package sort;

/**
 * 冒泡排序
 * @author toby Zhang
 * @date 2020-01-19 14:18
 * @description
 */
public class BubbleSort {

    public void sortAsASC(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j+1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
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
