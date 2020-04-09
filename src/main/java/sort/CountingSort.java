package sort;


/**
 * 计数排序
 * @author toby Zhang
 * @date 2020-03-04 09:01
 * @description
 */
public class CountingSort {

    /**
     * 计数排序，a是数组，n 是数组大小。假设数组中存放的都是非负数。
     *
     * @param a
     * @param n
     */
    public static void countingSort(int[] a, int n) {
        if (n < 1) return;
        int max = a[0];

        //查找数据中数组范围
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组C，大小max.
        int[] c = new int[max + 1];

        //计算每个元素的个数，放入C。
        for (int i=0; i < n; i++) {
            c[a[i]] ++;
        }

        // 依次累加
        for (int i= 1; i < max + 1; i++) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后
        int[] r = new int[n];
        // 计数排序关键步骤
        for (int i = n-1; i >=0; i--){
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]] --;
        }

        //将结果copy 到 a[]

        for (int i=0 ; i<n; i++) {
            a[i] = r[i];
        }
    }
}
