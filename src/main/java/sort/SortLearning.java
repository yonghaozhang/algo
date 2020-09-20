package sort;

import com.alibaba.fastjson.JSON;

public class SortLearning {


    public void bubbleSortASC(int[] a) {
        for(int i=0; i < a.length; i++) {
            boolean sorted = true;
            for (int j=i+1; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }

    void insertSortAsc(int[] a) {
        for (int i= 1; i < a.length; i++) {
            int value = a[i];
            int j=i-1;
            for (; j>0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    void selectionSortAsc(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
    }


    private void swap(int[] a, int pos1, int pos2) {
        int tmp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = tmp;
    }

    void mergeSortASC(int[] a, int p, int r) {
        // sort(p,r) = merge(sort(p,q), sort(q+1,r))
        if (p >=r) return;
        int q = (r - p)/ 2 + p;
        mergeSortASC(a, p, q);
        mergeSortASC(a, q+1, r);
        merge(a, p, q, r);
    }

    void merge(int a[], int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i = p;
        int j = q+1;
        int k = 0;
        while (i <=q && j<=r) {
            if (a[i] <=a[j]) {
                tmp[k] = a[i++];
            }else {
                tmp[k] = a[j++];
            }
        }
        // 判断mergeleft mergeright 有剩余元素
        int start = i;
        int end = q;
        if (j <= r) { // 右边有剩余元素
            start = j;
            end = r;
        }
        //将剩余元素copy到tmp;
        while (start < end) {
            tmp[k++] = a[start++];
        }

        //将tmp copy 到 a[p, r]
        for (int l=0; l<=r-p; l++) {
            a[p + l]  = tmp[l];
        }
    }

    void quickSort(int[] a, int p, int r) {
        // sort(p,r) = sort(p, q) + sort(q+1, r)
        // p >=r
        // 分区点q
        int q = partition(a, p ,r);
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }

    int partition(int[] a, int p, int r) {
       int pivotIndex = p;
       int pivotValue = a[r];
       for (int j=p; j < r; j++) {
           if (a[j] < pivotValue) {
               swap(a, j, pivotIndex);
               pivotIndex++;
           }
       }
       swap(a, pivotIndex, r);
       return pivotIndex;
    }

    void bucketSort(int[] a) {
        // 确定每个桶元素的大小范围
        int max = a[0];
        int min = a[a.length-1];
        for (int i=0; i<a.length-1;i++) {
            if (a[i] > max) {
                max = a[i];
            }else if (a[i] < min) {
                min = a[i];
            }
        }
        int bucketSize = 3;

        int bucketCount = (max - min) / bucketSize + 1;
        int[][] bucket = new int[bucketSize][bucketCount];
        int[] bucketElementNum = new int[bucketCount];
        // 元素下发到每个桶
        for (int i=0; i< a.length; i++) {
            int bucketIndex = (a[i] - min) / bucketSize;
            bucket[bucketIndex][bucketElementNum[bucketIndex]++] = a[i];
        }
        // 对每个桶进行排序
        int k = 0;
        for (int i=0; i < bucket.length; i++) {
            if (bucketElementNum[i] == 0 ) {
                continue;
            }
            quickSort(bucket[i], 0, bucketElementNum[i]);
            //将排序好的桶合并到原来数组
            for (int j= 0; j < bucketElementNum[i]; j++) {
                a[k++] = bucket[i][j];
            }
        }
    }


    //---------------------
    void countSort(int[] a, int n) {
        // 构建计数器数组c[]
        int max = a[0];
        for (int i=0;i<a.length;i++) {
            if (a[i] > max)
                max = a[i];
        }
        int[] c = new int[max];
        for (int i = 0; i<a.length;i++) {
            c[a[i]]++;
        }
        // 累加c[]
        for (int i=1; i<c.length; i++) {
            c[i] = c[i-1] +c[i];
        }
        // 排序到临时数组r[]
        int[] r = new int[a.length];
        for (int i =a.length-1; i>=0; i--) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }
        // copy到原数组a[]

    }

}
