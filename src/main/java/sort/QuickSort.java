package sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSort implements ISort {

    public void sort(int[] a) {
        sortInternally(a, 0 , a.length-1);
    }

    /**
     *
     * @param a
     * @param n - 数组内元素个数
     */
    public void sort(int[] a, int n) {
        sortInternally(a, 0, n-1);
    }

    private void sortInternally(int[]a, int p, int r) {
        if (p >= r) return;
        //找到分区点位置q
        int q = this.partition(a, p, r);
        this.sortInternally(a, p, q-1);
        this.sortInternally(a, q+1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivotValue = a[r]; // 分区点值,选择区间内最后一个元素的值作为分区点的值。
        int pivotIndex = p; // 分区点位置， 从区间第一个元素位置开始找。
        for(int j = p; j < r; ++j) { // 不用 <=
            if (a[j] < pivotValue) {
                if (pivotIndex == j) {
                    ++pivotIndex; //如果当前元素正好在分区点上，不用交换分区点和这个元素的位置
                } else {
                    int tmp = a[pivotIndex];
                    a[pivotIndex++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        // 将分区值放到分区位置上。
        int tmp = a[pivotIndex];
        a[pivotIndex] = pivotValue;
        a[r] = tmp;
        log.info("分区点位置：{}", pivotIndex);
        return pivotIndex;
    }

    private int partition2(int[] a, int startIndex, int endIndex) {
        int pivotValue = a[endIndex];
        int pivotIndex = startIndex;
        for (int j = startIndex; j < endIndex; j++) {
            if (a[j] < pivotValue) {
                int tmp = a[j];
                a[j] = pivotValue;
                a[pivotIndex] = tmp;
                pivotIndex++;
            }
        }

        int tmp = a[pivotIndex];
        a[pivotIndex] = pivotValue;
        a[endIndex] = tmp;

        return pivotIndex;
    }


}
