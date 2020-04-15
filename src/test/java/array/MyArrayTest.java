package array;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class MyArrayTest {

    @Test
    public void find() throws Exception {
        MyArray array = new MyArray(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(JSON.toJSONString(array));

        log.info(JSON.toJSONString(array.find(0)));
    }

    @Test
    public void insert() throws Exception {
        MyArray array = new MyArray(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(JSON.toJSONString(array));
    }

    @Test
    public void delete() throws Exception {
        MyArray array = new MyArray(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(JSON.toJSONString(array));

        array.delete(0);

        log.info(JSON.toJSONString(array));
        log.info(array.getCount() + "");

    }
}