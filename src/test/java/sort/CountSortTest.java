package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class CountSortTest {

    @Test
    public void sort() throws Exception {
        int[] a = {6,5,8,6,9,0,7,34,11,45,21,22,19,40};

        CountSort countSort = new CountSort();
        countSort.sort(a, a.length);
        log.info(Arrays.toString(a));

    }
}