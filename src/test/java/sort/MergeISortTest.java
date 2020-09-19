package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class MergeISortTest {

    @Test
    public void mergeSort() throws Exception {
        MergeSort sort = new MergeSort();
        int[] a = {6,5,8,6,9,0,7};

        sort.sort(a);
        log.info(Arrays.toString(a));

    }

}