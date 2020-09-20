package search;

public class SearchLearning {

    int bSearch(int[] a, int n, int value) {
        // 设置二分查找元素下标范围
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (high - low)/2 + low;
            if(value >  a[mid]) {
                low = mid + 1;
            }else if (value < a[mid]) {
                high= mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    double sqrt(double x, double precision) {
        if (x==0 || x==1) return x;
        if (x<0) return -1;
        //x是>1 还是<1
        double high,low;
        if (x>1) {
            high = x;
            low = 1;
        }else {
            high = 1;
            low = x;
        }
        double mid = (high - low)/2 + low;
        while (high-low>=precision) {
            if (mid*mid > x) {
                mid = x-precision;
            }else if (mid*mid <x) {
                mid = x+precision;
            }else {
                return mid;
            }
        }
        return mid;
    }


}
