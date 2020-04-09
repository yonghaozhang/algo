package sort;

/**
 * 基数排序
 * @author toby Zhang
 * @date 2020-03-04 09:32
 * @description
 */
public class RadixSort {

    public static void radixSort(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 获取位，从个位开始，对数组arr 按"指数"进行排序。
        for (int exp = 1; max /exp > 0; exp *=10) {
            countingSort(arr, exp);
        }
    }

    /**
     *
     * @param arr
     * @param exp
     */
    private static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数。
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[((arr[i])/ exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }

    }

}
