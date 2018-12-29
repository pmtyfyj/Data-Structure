package com.feng.set;

import java.util.ArrayList;

/**
 * @author: PMTY
 * @create: 2018-12-28 17:27
 **/
public class TestDemo {
//    public static void main(String[] args) {
//        System.out.println("pride and prejudice");
//        ArrayList<String> words1 = new ArrayList<>();
//        FileOperation.readFile("pride-and-prejudice.txt", words1);
//        System.out.println("Total words: " + words1.size());
//
//        BSTSet<String> set1 = new BSTSet<>();
//        for (String world : words1) {
//            set1.add(world);
//        }
//        System.out.println("Total different words: " + set1.getSize());
//    }

    public static void main(String[] args) {
        System.out.println("pride and prejudice");
                ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());
        LinkedListSet<String> listSet = new LinkedListSet<>();
        for (String world : words1) {
            listSet.add(world);
        }
        System.out.println("Total different words: " + listSet.getSize());
    }
}