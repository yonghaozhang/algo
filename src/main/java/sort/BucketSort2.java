package sort;

public class BucketSort2 implements ISort {

    private final int bucketSize = 3;

    private final ISort quickSort = new QuickSort();

    public void sort(int[] a) {
        if (a.length < 2) return;

        int min = a[0];
        int max = a[a.length-1];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < min) {
                min = a[i];
            }else if (a[i] > max){
                max = a[i];
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];


        int[] indexArr = new int[bucketCount];
        for (int i = 0; i < a.length; i++) {
            int bucketIndex = (a[i] - min) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                this.enCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = a[i];
        }

        int k = 0;
        for (int i= 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                return;
            }
            this.quickSort.sort(buckets[i], indexArr[i]);

            for (int j = 0; j < indexArr[i]; j++) {
                a[k++] = buckets[i][j];
            }
        }
    }

    public void sort(int[] a, int n) {
        // TODO: 2020/4/29
    }

    private void enCapacity(int[][] buckets, int bucketIndex) {
        int[] newArr = new int[buckets[bucketIndex].length <<2];
        for (int i = 0; i < buckets[bucketIndex].length; i++) {
            newArr[i] = buckets[bucketIndex][i];
        }
        buckets[bucketIndex] = newArr;
    }

    private void quickSort(int [] a, int n) {
        this.quickSort.sort(a, n);
    }
}
