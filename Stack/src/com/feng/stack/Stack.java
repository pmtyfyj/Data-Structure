package com.feng.stack;

/**
 * @author: PMTY
 * @create: 2018-12-24 16:21
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e); //添加数据
    E pop(); //取数据
    E peek(); //看栈顶的元素
}
