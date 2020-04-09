package stack;

/**
 * 基于数组实现的栈
 * @author toby Zhang
 * @date 2020-01-15 14:19
 * @description
 */
public class ArrayBaseStack {

    /**
     * 栈中元素
     */
    private String[] items;

    /**
     * 当前栈已用的空间大小
     */
    private int count;

    /**
     * 栈的容量
     */
    private int capacity;

    public ArrayBaseStack(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.count = 0;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == capacity) return false;
        items[count] = item;
        count ++;
        return true;
    }


    /**
     * 出站
     * @return
     */
    public String pop() {
        if (count == 0) return null;
        String item = items[count - 1];
        count --;
        return item;
    }



}
