package com.feng.linkedlist;

/**
 * @author: PMTY
 * @create: 2018-12-25 14:30
 **/
public class LinkedList<E> {

    private class  Node {
        public E e;
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }
    }
}
