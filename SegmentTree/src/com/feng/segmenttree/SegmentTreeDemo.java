package com.feng.segmenttree;

/**
 * 线段树
 * @author: PMTY
 * @create: 2018-12-30 15:43
 **/
public class SegmentTreeDemo {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a, b) -> a + b);
        System.out.println(segTree.query(0,2));
    }
}