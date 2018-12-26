package com.feng.stack;

/**
 * @author: PMTY
 * @create: 2018/12/26 20:26
 **/
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        sb.append(linkedList);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            listStack.push(i);
            System.out.println(listStack);
        }
        listStack.pop();
        System.out.println(listStack);
    }
}
