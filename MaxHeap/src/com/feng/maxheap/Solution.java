package com.feng.maxheap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 优先队列测试
 * @author: PMTY
 * @create: 2018-12-30 13:22
 **/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //存放元素出现的次数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }
}