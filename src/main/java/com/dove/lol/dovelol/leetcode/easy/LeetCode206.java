package com.dove.lol.dovelol.leetcode.easy;

import com.dove.lol.dovelol.leetcode.medium.ListNode;

/**
 * @author Dovelol
 * @date 2019/7/22 23:16
 * #206
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode list1 =  new ListNode(1);
        ListNode list2 =  new ListNode(2);
        ListNode list3 =  new ListNode(3);
        ListNode list4 =  new ListNode(4);
        ListNode list5 =  new ListNode(5);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        System.out.println(list1);


        ListNode listNode = reverseList(list1);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;

    }




}
