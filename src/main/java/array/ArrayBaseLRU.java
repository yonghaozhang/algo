package array;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的
 * @author toby Zhang
 * @date 2020-01-12 16:42
 * @description
 */
public class ArrayBaseLRU<T> {

    /**
     * 缓存数据的数组
     */
    private T[] value;

    /**
     * 缓存空间大小
     */
    private int capacity;

    /**
     * 缓存空间计数器
     */
    private int count = 0;

    /**
     * <缓存key,缓存在数组中的下标>
     */
    private Map<T, Integer> holder;

    /**
     *
     * @param capacity
     */
    public ArrayBaseLRU(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 缓存object
     * @param object
     */
    public void set(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null");
        }
        Integer index = holder.get(object);
        if (index == null) {
            // 缓存中没有指定的值
            if (isFull()) {
                // 缓存已满
                this.removeAndCache(object);
            }else {
                // 还有缓存空间
                this.cache(object, count);
            }
        }else {
            // 缓存中有指定的值，更新缓存值位置
            this.update(index);
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(value);
    }

    /**
     * 缓存数据到头部，但要先右移
     * @param object
     * @param pos 数组右移动的边界
     */
    private void cache(T object, int pos) {
        this.rightShift(pos);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存慢的情况下，踢出最后一个元素，最缓存到头部
     * @param object
     */
    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    /**
     * 更新缓存的位置
     * @param pos 缓存在数组中的位置
     */
    private void update(int pos) {
        T target = value[pos];
        this.rightShift(pos);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存空间是否已满
     * @return
     */
    private boolean isFull() {
        return count == capacity;
    }


    /**
     * pos 下标左边的数据统一右移一位
     * @param pos
     */
    private void rightShift(int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

}
