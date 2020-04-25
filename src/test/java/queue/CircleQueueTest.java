package queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author toby Zhang
 * @date 2020-01-16 19:04
 * @description
 */
@Slf4j
public class CircleQueueTest {

    @Test
    public void testEnqueue() throws Exception {
        CircleQueue queue = new CircleQueue(3);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        log.info(queue.toString());
        Assert.assertEquals("[1, 2, null]", queue.toString());

    }

    @Test
    public void testDequeue() throws Exception {
        CircleQueue queue = new CircleQueue(3);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        log.info(queue.toString());
        Assert.assertEquals("1", queue.dequeue());
        log.info(queue.toString());

        Assert.assertEquals("2", queue.dequeue());
        log.info(queue.toString());

        Assert.assertNull(queue.dequeue());
        log.info(queue.toString());
    }

}