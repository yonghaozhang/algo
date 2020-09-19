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
        if (a.length <=1) return;
        for (int i=1; i < a.length; i++) {
            int value = a[i]; //需要插入的元素
            int j = i - 1;
            //查找插入点，
            for(;j>=0;j--) { //从后往前比较
                if (a[j] > value) {
                    a[j+1] = a[j]; // 如果已排序组中的元素大于要插入的元素的值，就将这个元素向后挪动一位。
                }else {
                    break;
                }
            }
            a[j+1] = value; // 插入点是j+1
        }
    }


}
