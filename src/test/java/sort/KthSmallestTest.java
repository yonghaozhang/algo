package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class KthSmallestTest {

    @Test
    public void sort() throws Exception {
        int[] a = {6,5,8,6,9,0,7};
        KthSmallest kthSmallest = new KthSmallest();
        int value = kthSmallest.sort(a, 3);
        log.info(value+"");
    }
}