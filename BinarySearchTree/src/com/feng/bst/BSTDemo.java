package com.feng.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: PMTY
 * @create: 2018-12-28 12:11
 **/
public class BSTDemo {
    public static void main(String[] args) {
//        int[] nums = {5,3,6,8,4,2};
//        BST<Integer> bst = new BST<>();
//        for (int num : nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        bst.levelOrder();
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 10000;
        for (int i = 0;  i < n; i++) {
            bst.add(random.nextInt(n));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");
    }
}