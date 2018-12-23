package com.feng.array;

/**
 * 数组结构
 * @author: PMTY
 * @create: 2018/12/23 21:24
 **/
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[] {98,87,100};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }
}
