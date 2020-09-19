package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

@Slf4j
public class QuickISortTest {

    @Test
    public void sort() throws Exception {
        int[] a = {6,5,8,6,9,0,7};
        QuickSort sort = new QuickSort();
        sort.sort(a);
        log.info(Arrays.toString(a));

        QuickSort sort2 = new QuickSort();
        sort2.sort(a);
        log.info(Arrays.toString(a));

    }
}