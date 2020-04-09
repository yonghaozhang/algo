package queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-01-16 18:31
 * @description
 */
@Slf4j
public class LinkedListQueueTest {

    @Test
    public void testEnqueue() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        log.info(queue.toString());
        Assert.assertEquals("1,2,3,4,", queue.toString());
    }

    @Test
    public void testDequeue() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(4, queue.dequeue());
        Assert.assertEquals(-1, queue.dequeue());
    }


}