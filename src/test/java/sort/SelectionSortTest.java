package sort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-01-20 10:14
 * @description
 */
@Slf4j
public class SelectionSortTest {

    @Test
    public void sort() throws Exception {
        SelectionSort sort = new SelectionSort();
        int[] arr = new int[]{4,7,2,9,1,5};
        sort.sort(arr);
        log.info(JSON.toJSONString(arr));
    }
}