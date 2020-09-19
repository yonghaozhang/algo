package sort;

public class CountSort implements ISort {

    public void sort(int[] a) {
        // TODO: 2020/5/6
    }

    /**
     * 假设都是非负数。
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        if (n <= 1) return;
        // 查找数组值的范围。
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        //将数组元素以值为下标，放到计数器中。
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        // 累加计数器
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i-1] + c[i];
        }

        // 排序, 从原数组a中从后往前扫描数组(为了确保是稳定排序)，比如发现3时，c[3]的值表示有多少个元素<=3, 比如有4个的话， 3的位置就是r[4-1], 然后c[3] -1
        int[] r = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将排序好的r[] copy 到 a数组
        for(int i = 0; i < n; i++) {
            a[i] = r[i];
        }

    }
}
