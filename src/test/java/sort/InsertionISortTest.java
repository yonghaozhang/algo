package sort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-01-20 09:56
 * @description
 */
@Slf4j
public class InsertionISortTest {

    @Test
    public void testSort() throws Exception {
        InsertionSort sort = new InsertionSort();
        int[] arr = new int[]{5,1,7,2,9,4};
        sort.sort(arr);
        log.info(JSON.toJSONString(arr));
    }
}