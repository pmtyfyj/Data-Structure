package com.feng.stack;

/**
 * 二次封装数组
 * @author: PMTY
 * @create: 2018-12-24 10:22
 **/
public class Array<E> {
    private E[] data;
    private int size;

    //构造函数，传入数组容量
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //空参构造
    public Array() {
        this(10);
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组元素个数
    public int getSize() {
        return size;
    }

    //数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //像所有元素后添加一个元素
    public void addLast(E e) {
        add(size,e);
    }

    //在所有元素前添加元素
    public void addFirst(E e) {
        add(0,e);
    }

    //在第index个位置上插入一个元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
//            throw new IllegalArgumentException("Add failed. Array is already full.");
            //如果数组满了，要动态扩容
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal.");
        }
        return data[index];
    }

    //获取数据第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取数组最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改索引index位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组是否包含元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找元素所在的索引，如果没有就返回-1
    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        E tmp = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        //loitering objects 闲散对象，并不等于memory leak 内存泄漏，加这句话为了让垃圾回收
        data[size] = null;
        if (size == (data.length / 4) && (data.length / 2 != 0)) {
            resize(data.length / 2);
        }

        return tmp;
    }

    //删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除指定元素
    public void removeElement(E e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    //动态数组
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}