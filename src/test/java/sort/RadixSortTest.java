package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

@Slf4j
public class RadixSortTest {

    @Test
    public void radixSort() throws Exception {
        int[] a = {6,5,8,6,9,0,7,34,11,45,21,22,19,40};
        RadixSort sort = new RadixSort();
        sort.radixSort(a);
        log.info(Arrays.toString(a));


    }
}