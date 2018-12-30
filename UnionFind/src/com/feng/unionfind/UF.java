package com.feng.unionfind;

/**
 * @author: PMTY
 * @create: 2018/12/30 19:54
 **/
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
