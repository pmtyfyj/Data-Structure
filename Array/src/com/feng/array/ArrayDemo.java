package com.feng.array;

/**
 * 数组结构
 * @author: PMTY
 * @create: 2018/12/23 21:24
 **/
public class ArrayDemo {
    public static void main(String[] args) {
//        demo();
        demo1();
    }

    public static void demo() {
        int[] arr = new int[10];
        arr[2] = 10;
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
            System.out.println(arr[i]);
        }


//        int[] scores = new int[] {98,87,100};
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
//        }
    }

    public static void demo1() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());
        arr.add(1,100);
        System.out.println(arr.toString());
        arr.addFirst(-1);
        System.out.println(arr.toString());

        arr.remove(2);
        System.out.println(arr.toString());
        arr.removeFirst();
        System.out.println(arr.toString());
        arr.removeLast();
        System.out.println(arr.toString());
        arr.removeElement(5);
        System.out.println(arr.toString());
    }
}
