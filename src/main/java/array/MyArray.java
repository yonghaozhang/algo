package array;

/**
 * 数组的插入，删除，按下标随机访问操作
 */
public class MyArray {

    public int data[]; // 保存数据

    private int n; // 数组长度

    private int count; // 数组中元素个数。

    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 按下标查询
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= n) return -1;
        return data[index];
    }

    /**
     * 在指定位置插入
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        if (count == n)  return false;
        if (index < 0 || index > count) return false;

        // 指定位置和位置之后的数据向后挪一位。
        for (int i= count; i > index; i--) {
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
        if (index<0 || index >count) return false;

        // 指定位置开始，后面的数据向前移挪一位
        for (int i= index + 1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    public int getCount() {
        return count;
    }
}
