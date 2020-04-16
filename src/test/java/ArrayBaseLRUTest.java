import array.ArrayBaseLRU;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author toby Zhang
 * @date 2020-01-12 18:41
 * @description
 */
@Slf4j
public class ArrayBaseLRUTest {

    @Test
    public void testOffer() throws Exception {
        ArrayBaseLRU<Integer> lru = new ArrayBaseLRU<Integer>(3);
        lru.set(1);
        log.info(lru.toString());
        lru.set(2);
        log.info(lru.toString());
        lru.set(3);
        log.info(lru.toString());
        lru.set(4);
        log.info(lru.toString());
        lru.set(5);
        log.info(lru.toString());
        lru.set(6);
        log.info(lru.toString());
        lru.set(7);
        log.info(lru.toString());
        lru.set(8);
        log.info(lru.toString());
        lru.set(9);
        log.info(lru.toString());
    }

    @Test
    public void testOfferIfCacheKeyExist() throws Exception {
        ArrayBaseLRU<Integer> lru = new ArrayBaseLRU<Integer>(3);
        lru.set(1);
        log.info(lru.toString());
        lru.set(2);
        log.info(lru.toString());
        lru.set(3);
        log.info(lru.toString());
        lru.set(4);
        log.info(lru.toString());
        lru.set(2);
        log.info(lru.toString());
        lru.set(2);
        log.info(lru.toString());
    }


}