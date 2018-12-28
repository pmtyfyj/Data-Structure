package com.feng.set;

/**
 * @author: PMTY
 * @create: 2018-12-28 17:06
 **/
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
