package search;

/**
 * 二分查找
 * @author toby Zhang
 * @date 2020-03-05 16:51
 * @description
 */
public class BinarySearch {

    /**
     * 非递归方式
     * @param a
     * @param n - 数组元素个数
     * @param value
     * @return 查找元素的下标
     */
    public int bSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high-low) >> 1);
            if (a[mid] == value) {
                return mid;
            }else if (a[mid] < value) {
                low = mid + 1;

            }else
                high = mid - 1;
        }
        return -1;
    }

    /**
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearchRecursion(int[] a, int n, int value) {
        return bSearchInternal(a, 0, n -1, value);
    }


    /**
     * 查找第一个值等于给定值的元素。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            }else if (a[mid] < value) {
                low = mid + 1;
            }else {
                if ((mid == 0) || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>1);
            if (a[mid] > value) {
                high = mid - 1;
            }else if (a[mid] < value) {
                low = mid + 1;
            }else {
                if ((mid == n - 1) || a[mid + 1] == value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素。
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else  high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于给定值的元素。
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (value >= mid) {
                if ((mid == n -1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 近似求一个数的平方根，精确到小数点后precision位。
     * @param x
     * @param precision
     * @return
     */
    public double sqrt(double x, double precision) {
        if (x == 1) return 1;
        if (x < 0) return -1;

        double high;
        double low;
        if (x > 0 && x < 1) {
            high = 1;
            low = x;
        }else {
            // x>1
            high = x;
            low = 1;
        }
        double mid = (low + high) / 2;
        while (high - low >= precision) {
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                high = mid - precision;
                mid = (low + high)/2;
            }else {
                low = mid + precision;
                mid = (low + high)/2;
            }
        }
        return mid;
    }

    /**
     * 递归近似求一个数的平方根，精确到小数点后precision位。
     * @param x
     * @param precision
     * @return
     */
    public double sqrtRecursion(double x, double precision) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x > 0 && x < 1) {
            return this.sqrtRecursionInternal(x, 1, x, precision);
        }else {
            return this.sqrtRecursionInternal(x, x, 1, precision);
        }
    }

    private double sqrtRecursionInternal(double x, double high, double low, double precision) {
        double mid = (high + low) / 2;
        if (high - low <= precision) return mid; // 终止条件
        if (mid * mid == x) {
            return mid;
        }else if (mid * mid < x) {
            return this.sqrtRecursionInternal(x, high, mid + precision, precision);
        }else {
            return this.sqrtRecursionInternal(x, mid - precision, low, precision);
        }
    }



    private int bSearchInternal(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        }else if (a[mid] < value) {
            return this.bSearchInternal(a, mid+1, high, value);
        }else {
            return bSearchInternal(a, low, mid-1, value);
        }
    }

}
