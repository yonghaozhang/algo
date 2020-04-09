package queue;


/**
 * 用数组实现的队列
 * @author toby Zhang
 * @date 2020-01-16 16:29
 * @description
 */
public class ArrayQueue {

    private String[] items;

    private int head = 0;

    private int tail = 0;

    private int capacity;


    /**
     * construct
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
    }


    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == capacity) {
            if (head ==0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            head = 0;
            tail -= head;
            items[tail++] = item;
            return true;
        }
        return false;
    }


    public String dequeue() {
        if (head == tail) return null;
        return items[head++];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=head; i< tail; i++){
            sb.append(items[i]).append(",");
        }
        return sb.toString();
    }
}
