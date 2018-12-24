package com.feng.stack;

/**
 * 栈结构
 * @author: PMTY
 * @create: 2018-12-24 16:41
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}