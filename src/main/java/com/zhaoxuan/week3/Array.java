package com.zhaoxuan.week3;

import java.util.Arrays;

public class Array {

    private int[] data;
    // 数组元素实际个数，指向数组中第一个没有元素的位置
    private int size;

    // 无参构造函数，默认数组容量为10
    public Array() {
        this(10);
    }

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 获取元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个元素
    public void addLast(int e) {
        if (isFull()) {
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        }
        add(e, size);
    }

    // 数组是否已满
    public boolean isFull() {
        if (size == data.length) {
            return true;
        }
        return false;
    }

    // 向指定位置index添加元素e
    public void add(int e, int index) {
        if (isFull()) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require idnex >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向index为0的位置添加元素e
    public void addFirst(int e) {
        add(e, 0);
    }

    // 获取index索引位置的元素
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中是否有元素e，返回索引，不存在返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 删除索引处为index的元素，并返回删除的元素值
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    // 删除第一个元素，返回删除的元素值
    public int removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素，返回删除的元素值
    public int removeLast() {
        return remove(size - 1);
    }

    // 删除元素e
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
