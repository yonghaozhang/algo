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
     * @param n
     * @param value
     * @return
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
                high = mid + 1;
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
                else  low = mid -1;
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
