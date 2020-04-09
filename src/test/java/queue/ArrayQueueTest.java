package queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import queue.ArrayQueue;

/**
 * @author toby Zhang
 * @date 2020-01-16 17:06
 * @description
 */
@Slf4j
public class ArrayQueueTest {

    @Test
    public void testEnqueue() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        boolean success = queue.enqueue("d");
        log.info(queue.toString());
        Assert.assertFalse(success);

    }

    @Test
    public void dequeue() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        String item = queue.dequeue();
        log.info(queue.toString());
        Assert.assertEquals("a", item);

    }

}