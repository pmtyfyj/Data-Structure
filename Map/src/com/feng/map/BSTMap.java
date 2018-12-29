package com.feng.map;

import java.util.ArrayList;

/**
 * @author: PMTY
 * @create: 2018-12-29 12:30
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left,right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    //像二分搜索树添加元素e
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    //像以node为根的二分搜索树添加元素e(Key Value)，递归算法
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }
        return node;
    }
    //返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        }else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }else {
            return node;
        }
    }

    //删除二分搜索树中元素为key的节点
    @Override
    public V remove(K key) {
        return null;
    }
    //删除以node为根节点，元素为key的元素，递归算法
    public Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }else {
            //待删除左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除左右子树均不为空的情况
            //找到比待删除节点大的最小节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    //返回以node为根的二分搜索树最小节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    //删除以node为根的二分搜索树最小根节点
    private Node removeMin(Node node) {
         if (node.left == null) {
             Node rightNode = node.right;
             node.right = null;
             size --;
             return rightNode;
         }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)) {
            System.out.println("Total words: " + words.size());
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word,map.get(word) + 1);
                }else {
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PRREJUDICE: " + map.get("prejudice"));
        }
    }
}