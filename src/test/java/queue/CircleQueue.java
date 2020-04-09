package queue;


/**
 * 循环队列
 * @author toby Zhang
 * @date 2020-01-16 18:41
 * @description
 */
public class CircleQueue {

    private int[] items;

    private int capacity;

    private int head = 0;

    private int tail = 0;


    public CircleQueue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean enqueue(int item) {
        int next = (tail + 1) % capacity;
        if (next == head) return false;
        items[tail] = item;
        tail = next;
        return true;
    }


    public int dequeue() {
        if (head == tail) return -1;
        int item = items[head];
        head = (head + 1) % capacity;
        return item;
    }

    @Override
    public String toString() {
        if (0 == capacity) return 0 + "";
        StringBuilder sb = new StringBuilder();
        for (int i = head; i % capacity != tail; i = (i+1) % capacity) {
            sb.append(items[i]).append(",");
        }
        return sb.toString();
    }
}
