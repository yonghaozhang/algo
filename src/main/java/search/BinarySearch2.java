package search;

public class BinarySearch2 {


    public int binarySearch(int a[], int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == x) {
                return mid;
            }else if (a[mid] > x) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int bSRecursion(int a[], int n, int x) {
        return this.recursionInternally(a, 0, n-1, x);
    }

    /**
     * 查找第一个值等于给定值的元素。
     * @param a
     * @param n
     * @param x
     * @return
     */
    public int binarySearchFirstEquals(int a[], int n , int x) {
        if (a == null || a.length == 0) return -1;
        int high = n;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == x) {
                if (mid != 0 && a[mid - 1] != x) return mid;
                high = mid - 1;
            }else if (a[mid] > x) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素。
     * @param a
     * @param n
     * @param x
     * @return
     */
    public int binarySearchLastEquals(int a[], int n , int x) {
        if (a == null || a.length == 0) return -1;
        int high = n;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == x) {
                if (mid == n - 1 || a[mid + 1] != x) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else if (a[mid] < x) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素。
     * @param a
     * @param n
     * @param x
     * @return
     */
    public int binarySearchFirstLargeEquals(int a[], int n, int x) {
        if (a == null || a.length == 0) return -1;
        int high = n-1;
        int low = 0;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= x) {
                if (mid == 0 || a[mid - 1] < x) return mid;
                high = mid - 1;
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
     * @param x
     * @return
     * @throws Exception
     */
    public int binarySearchLastLessThan(int a[], int n, int x) throws Exception {
        if (a == null || a.length == 0) return -1;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= x) {
                if (mid == n - 1 || a[mid + 1] > x) return mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }


    private int recursionInternally(int a[], int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            high = mid - 1;
            return this.recursionInternally(a, low, high, value);
        }else {
            low = mid + 1;
            return this.recursionInternally(a, low, high, value);
        }
    }

}
