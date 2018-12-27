package com.feng.element.digui;

/**
 * 递归求数组和
 * @author: PMTY
 * @create: 2018-12-27 10:55
 **/
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    public static int sum(int[] arr, int l) {
        if (arr.length == l) {
            return 0;
        }
        return arr[l] + sum(arr,l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(arr));
    }
}