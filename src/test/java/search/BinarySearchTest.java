package search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BinarySearchTest {

    @Test
    public void bSearch() throws Exception {
        int[] arr = new int[]{1,2,3,4,6,7};
        BinarySearch binarySearch = new BinarySearch();
        int value = binarySearch.bSearch(arr, arr.length, 4);
        log.info(value + "");

        int v = binarySearch.bSearchRecursion(arr, arr.length, 4);
        log.info(v + "");
    }

    @Test
    public void sqrt() throws Exception {
        double x = 0.04;
        BinarySearch binarySearch = new BinarySearch();
        double value = binarySearch.sqrt(x, 1e-10);
        double value2 = binarySearch.sqrtRecursion(x, 1e-10);
        log.info(value + "");
        log.info(value2 + "");

        double v = binarySearch.sqrt(9, 1e-10);
        double v2 = binarySearch.sqrtRecursion(9, 1e-10);
        log.info(v + "");
        log.info(v2 + "");
    }

    @Test
    public void binarySearchFirstElement() throws Exception {
        int[] arr = new int[]{1,2,3,4,4,6,7};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.bSearch1(arr, 7, 4);
        log.info(index + "");

    }

    @Test
    public void binarySearchLastElement() throws Exception {
        int[] arr = new int[]{1,2,3,4,4,6,7};
//        BinarySearch2 binarySearch2 = new BinarySearch2();
//        int index2 = binarySearch2.binarySearchLastEquals(arr, 7, 4);
//        log.info(index2 + "");
    }

    @Test
    public void binarySearchFirstLargeThan() throws Exception {
        int[] arr = new int[]{1,2,3,4,4,6,7};
//        BinarySearch2 binarySearch2 = new BinarySearch2();
//        int x = binarySearch2.binarySearchFirstLargeEquals(arr, 7, 4);
//        log.info(x + "");
    }

    @Test
    public void binarySearchLastLessThan() throws Exception {
        int[] arr = new int[]{1,2,3,4,4,6,7};
//        BinarySearch2 binarySearch2 = new BinarySearch2();
//        int x  = binarySearch2.binarySearchLastLessThan(arr, 7, 4);
//        log.info(x + "");
    }




}