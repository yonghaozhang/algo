package sort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-01-19 15:16
 * @description
 */
@Slf4j
public class BubbleISortTest {

    @Test
    public void testSortAsASC() throws Exception {
        BubbleSort sort = new BubbleSort();
        int[] arr = new int[]{4,2,6,3,7,1};
        sort.sortAsASC(arr);
        log.info(JSON.toJSONString(arr));
    }

    @Test
    public void testSortAsASC2() throws Exception {
        BubbleSort sort = new BubbleSort();
        int[] arr = new int[]{4,2,6,3,7,1};
        sort.sortAsASC2(arr, 6);
        log.info(JSON.toJSONString(arr));
    }


    @Test
    public void testRegx() throws Exception {
        String text = "好的，谢谢5eRh6iglP2好的，谢谢";
        Pattern pattern = Pattern.compile("[5-9]{1}[0-9a-zA-Z]{8,10}[2-5]{1}" );
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}