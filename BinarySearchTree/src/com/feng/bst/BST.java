package com.feng.bst;

/**
 * 二分搜索树
 * @author: PMTY
 * @create: 2018-12-27 16:06
 **/
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.left = null;
            this.right = null;
            this.e = e;
        }
    }

    private Node root;  //根节点
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树添加元素e
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size ++;
        }else {
            add(root,e);
        }
    }

    //向以node为根的二分搜索树添加元素
    public void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {  //左子树
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {  //右子树
            node.right = new Node(e);
            size ++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }
}