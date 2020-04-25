package queue;

public interface MyQueue {

    /**
     * 入栈
     * @param item
     * @return
     */
    boolean enqueue(String item);

    String dequeue();
}
