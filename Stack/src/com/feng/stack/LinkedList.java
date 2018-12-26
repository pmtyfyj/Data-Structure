package com.feng.stack;

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

    private Node dummyHead;  //链表实现中常用的虚拟头节点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
        add(0,e);
    }

    //在链表index位置添加新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        //先遍历找到要添加节点的前面一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }

    //在链表末尾添加元素e
    public void addLast(E e) {
        add(size,e);
    }

    //获取链表中第index元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;  //从0索引开始
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表中第一个元素
    public E getFirst() {
        return get(0);
    }
    //获取链表中最后一个元素
    public E getLast() {
        return get(size - 1);
    }
    //修改链表中第index位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    //从链表中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;  //获取要删除节点的前一个节点
        }
        Node retNode = prev.next; //获取要删除的节点
        prev.next = retNode.next;
        size --;
        retNode.next = null;
        return retNode.e;
    }

    //从链表中删除第一个节点数据
    public E removeFirst() {
        return remove(0);
    }
    //从来链表中删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }

//        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
//            sb.append(cur + "->");
//        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,888);
        System.out.println(linkedList);

        System.out.println("==========================");
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
