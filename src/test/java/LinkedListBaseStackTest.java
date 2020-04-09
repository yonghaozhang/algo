import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import stack.LinkedListBaseStack;

/**
 * @author toby Zhang
 * @date 2020-01-15 15:19
 * @description
 */
@Slf4j
public class LinkedListBaseStackTest {

    @Test
    public void testPush() {
        LinkedListBaseStack stack = new LinkedListBaseStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        log.info(stack.toString());
    }

    @Test
    public void pop() {
        LinkedListBaseStack stack = new LinkedListBaseStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        log.info(stack.toString());

        stack.pop();
        log.info(stack.toString());

        stack.pop();
        log.info(stack.toString());

        stack.pop();
        log.info(stack.toString());

        stack.pop();
        log.info(stack.toString());

        stack.pop();
        log.info(stack.toString());

    }
}