package sort;

public class BucketSort implements ISort {

    private int bucketSize = 3;

    private final ISort sort = new QuickSort();

    public void sort(int[] a) {
        if (a.length < 2) return;

        // 找出待排序数组中最大和最小元素，用于确定桶里数据的范围。
        int max = a[0];
        int min = a[a.length-1];
        for (int i = 0; i < a.length-1;i++) {
            if (a[i] > max) {
                max = a[i];
            }else if (a[i] < min) {
                min = a[i];
            }
        }
        int bucketCount = (max-min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];

        // 将数据分配到桶里。
        int[] indexArr =new int[bucketCount]; // indexArr[i] 标识第i个桶内能放几个元素。
        for(int i = 0; i < a.length; i++) {
            int bucketIndex = (a[i] - min) / bucketSize; // bucketIndex标识那个桶
//            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
//                // 扩容
//                ensureCapacity(buckets, bucketIndex);
//            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = a[i];
        }

        // 对每个桶进行快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue; // 某个桶中没有元素
            }
            this.quickSort(buckets[i], indexArr[i]);
            // 将各个桶快排后的数据放回原数组
            for (int j = 0; j < indexArr[i]; j++) {
                a[k++] = buckets[i][j];
            }
        }
    }

    public void sort(int[] a, int n) {
        // TODO: 2020/4/29
    }

    private void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] newArr =new int[buckets[bucketIndex].length * 2];
        for (int j = 0; j < buckets[bucketIndex].length; j++) {
            newArr[j] = buckets[bucketIndex][j];
        }
        buckets[bucketIndex] = newArr;
    }

    private void quickSort(int[] bucket, int n) {
        sort.sort(bucket, n);

    }

}
