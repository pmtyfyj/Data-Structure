package com.feng.queue.array;

/**
 * @author: PMTY
 * @create: 2018-12-25 10:54
 **/
public interface Queue<E> {
    int getSize();  //获取数量
    boolean isEmpty(); //判断是否为空
    void enqueue(E e); //入队
    E dequeue();  //出队
    E getFront(); //获取数据
}
