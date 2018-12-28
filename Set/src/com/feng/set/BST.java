package com.feng.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        }else {
//            add(root,e);
//        }
        root = add(root, e);
    }

    //向以node为根的二分搜索树添加元素
    //返回插入新节点后二分搜索树的根
    public Node add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {  //左子树
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {  //右子树
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0) {
//            add(node.left,e);
//        }else {
//            add(node.right,e);
//        }
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {  //左子树
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {  //右子树
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }
    //看以node为根的二分搜索树是否包含元素e，递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return false;
        }else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }else {
            return contains(node.left, e);
        }
    }

    //二分搜索树前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //以node为根的二分搜索树前序遍历，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树非递归前序遍历
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            //根据栈的特性，要先压入右节点，在压入左节点
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    //二分搜索树层序遍历，广度优先遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.e);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    //二分搜索树中序遍历
    public void inOrder() {
        inOrder(root);
    }
    //以node为根节点的二分搜索树中序遍历，递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树后序遍历
    public void postOrder() {
        postOrder(root);
    }
    //以node为节点的二分搜索树后序遍历，递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //寻找二分搜索树最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }
    //以node为节点的二分搜索树最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    //寻找二分搜索树最大的元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }
    //以node为节点的二分搜索树最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //删除二分搜索树中最小根节点，返回表被删除的元素
    public E removeMin() {
        E min = minimum();
        root = removeMin(root);
        return min;
    }
    //删除已node为根节点的二分搜索树最小根节点 递归算法
    public Node removeMin(Node node) {
        if (node.left == null) {
            //最小根节点
            Node newRightNode = node.right;
            node.right = null;
            size --;
            return newRightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //删除二分搜索树中最大根节点，返回被删除元素
    public E removeMax() {
        E max = maximum();
        root = removeMax(root);
        return max;
    }
    //删除以node为根节点的最大根节点
    public Node removeMax(Node node) {
        if (node.right == null) {
            Node newLeftNode = node.left;
            node.left = null;
            size --;
            return newLeftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中元素为e的节点
    public void remove(E e) {
        root = remove(root,e);
    }
    //删除以node为节点元素为e的的根节点，递归算法
    private Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }else {
            //说明当前e是相等的
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node newRightNode = node.right;
                node.right = null;
                size --;
                return newRightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node newLeftNode = node.left;
                node.left = null;
                size --;
                return newLeftNode;
            }
            //左右子树都不为空的情况
            //找到待删除节点右子树最小的节点，用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.left = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    //生成以node为节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, (depth + 1), sb);
        generateBSTString(node.right, (depth + 1), sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}