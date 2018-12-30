package com.feng.maxheap;

import java.util.Random;

/**
 * 最大堆
 * @author: PMTY
 * @create: 2018-12-30 11:34
 **/
public class MaxHeapDemo {
    public static void main(String[] args) {
        int n = 10000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt());
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }
}