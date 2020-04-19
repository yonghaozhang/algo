package stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArrayBaseStackTest {

    @Test
    public void push() throws Exception {
        ArrayBaseStack stack = new ArrayBaseStack(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        log.info(stack.toString());
    }

    @Test
    public void pop() throws Exception {
        ArrayBaseStack stack = new ArrayBaseStack(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        log.info(stack.toString());

        String item = stack.pop();
        log.info(item);
        log.info(stack.toString());
    }
}