package sort;

/**
 * @author toby Zhang
 * @date 2020-01-19 15:40
 * @description
 */
public class InsertionSort {


    /**
     * 插入排序法
     * @param a
     */
    public void sort(int[] a) {
        if (a.length <= 1) return;

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (;j>=0;j--) {
                if (a[j] > value) {
                    a[j+1] = a [j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }


}
