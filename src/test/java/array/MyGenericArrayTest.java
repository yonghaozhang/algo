package array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class MyGenericArrayTest {

    @Test
    public void find() throws Exception {
        MyGenericArray array = new MyGenericArray<Integer>(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(array.toString());
        log.info(array.find(0).toString());
    }

    @Test
    public void insert() throws Exception {
        MyGenericArray array = new MyGenericArray<Integer>(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(array.toString());
    }

    @Test
    public void delete() {
        MyGenericArray array = new MyGenericArray<Integer>(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        log.info(array.toString());
        array.delete(0);
        log.info(array.toString());
    }

}