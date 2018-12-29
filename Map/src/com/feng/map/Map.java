package com.feng.map;

/**
 * @author: PMTY
 * @create: 2018-12-29 11:01
 **/
public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
