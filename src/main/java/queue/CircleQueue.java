package queue;

import java.util.Arrays;

public class CircleQueue implements MyQueue {

    private String[] items;

    private int n;

    private int head = 0;

    private int tail = 0;

    public CircleQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) return false; // 队列满了
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String e = items[head];
        head = (head + 1) % n;
        return e;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
