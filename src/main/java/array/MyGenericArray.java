package array;

import java.util.Arrays;

public class MyGenericArray<T> {

    private T[] data;
    private int n;
    private int count;

    public MyGenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 按下标查询
     * @param index
     * @return
     */
    public T find(int index) {
        if (index < 0 || index >= count) return null;
        return data[index];
    }

    /**
     * 在指定位置插入
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, T value) {
        if (index < 0 || index > count) return false;
        //扩容
        if (count == n) this.resize(n<<1);
        // 插入位置和之后的元素向后挪一位。
        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index <0 || index > count) return false;
        // 删除位置和之后的元素向前挪一位
        for (int i=index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    public int getCount() {
        return count;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "MyGenericArray{" +
                "data=" + Arrays.toString(data) +
                ", n=" + n +
                ", count=" + count +
                '}';
    }
}
