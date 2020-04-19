package linkedlist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class LinkedListBaseLRUTest {

    @Test
    public void add() throws Exception {
        LinkedListBaseLRU<Integer> list = new LinkedListBaseLRU<Integer>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        log.info(list.toString());

        list.add(1);
        log.info(list.toString());
    }
}