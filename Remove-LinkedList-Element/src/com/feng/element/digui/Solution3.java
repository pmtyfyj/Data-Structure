package com.feng.element.digui;

import com.feng.element.ListNode;

/**
 * 链表递归删除元素
 * @author: PMTY
 * @create: 2018-12-27 11:10
 **/
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

//        ListNode res = removeElements(head.next,val);
//        if (head.val == val) {
//            return res;
//        }else {
//            head.next = res;
//            return head;
//        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);
        ListNode node = new Solution3().removeElements(listNode, 6);
        System.out.println(node);
    }
}