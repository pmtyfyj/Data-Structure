package com.feng.segmenttree;

/**
 * @author: PMTY
 * @create: 2018-12-30 15:41
 **/
public interface Merger<E> {
    E merge(E a, E b);
}
