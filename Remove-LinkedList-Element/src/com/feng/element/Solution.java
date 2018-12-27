package com.feng.element;

/**
 * @author: PMTY
 * @create: 2018-12-27 09:45
 **/
public class Solution {

//    public ListNode removeElements(ListNode head, int val) {
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = delNode.next;
//            delNode.next = null;
//        }
//
//        if (head == null) {
//            return null;
//        }
//
//        ListNode prev = head;
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//            } else {
//                prev = prev.next;
//            }
//        }
//        return head;
//    }


    //使用虚拟头节点
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);
        ListNode node = new Solution().removeElements(listNode, 6);
        System.out.println(node);
    }
}