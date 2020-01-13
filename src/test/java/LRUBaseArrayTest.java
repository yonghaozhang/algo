import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-01-12 18:41
 * @description
 */
@Slf4j
public class LRUBaseArrayTest {

    @Test
    public void testOffer() throws Exception {
        LRUBaseArray<Integer> lru = new LRUBaseArray<Integer>(3);
        lru.offer(1);
        log.info(lru.toString());
        lru.offer(2);
        log.info(lru.toString());
        lru.offer(3);
        log.info(lru.toString());
        lru.offer(4);
        log.info(lru.toString());
        lru.offer(5);
        log.info(lru.toString());
        lru.offer(6);
        log.info(lru.toString());
        lru.offer(7);
        log.info(lru.toString());
        lru.offer(8);
        log.info(lru.toString());
        lru.offer(9);
        log.info(lru.toString());
    }

    @Test
    public void testOfferIfCacheKeyExist() throws Exception {
        LRUBaseArray<Integer> lru = new LRUBaseArray<Integer>(3);
        lru.offer(1);
        log.info(lru.toString());
        lru.offer(2);
        log.info(lru.toString());
        lru.offer(3);
        log.info(lru.toString());
        lru.offer(4);
        log.info(lru.toString());
        lru.offer(2);
        log.info(lru.toString());
        lru.offer(2);
        log.info(lru.toString());
    }


}