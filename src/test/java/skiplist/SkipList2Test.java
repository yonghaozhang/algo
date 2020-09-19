package skiplist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class SkipList2Test {

    @Test
    public void insert() throws Exception {

        SkipList2 skipList2 = new SkipList2();
        skipList2.insert(1);
        skipList2.insert(2);
        skipList2.insert(3);
        skipList2.insert(4);
        skipList2.insert(5);
        skipList2.insert(6);
        skipList2.insert(7);
        skipList2.insert(8);
        skipList2.insert(9);
        skipList2.insert(10);
        skipList2.insert(11);
        skipList2.insert(12);
        skipList2.insert(13);

        log.info(skipList2.toString());
    }

    @Test
    public void find() throws Exception {
        SkipList2 skipList2 = new SkipList2();
        skipList2.insert(1);
        skipList2.insert(2);
        skipList2.insert(3);
        skipList2.insert(4);
        skipList2.insert(5);
        skipList2.insert(6);
        skipList2.insert(7);
        skipList2.insert(8);
        skipList2.insert(9);
        skipList2.insert(10);
        skipList2.insert(11);
        skipList2.insert(12);
        skipList2.insert(13);

        log.info(skipList2.toString());
        SkipList2.Node v = skipList2.find(9);
        log.info(v.toString());
    }
}