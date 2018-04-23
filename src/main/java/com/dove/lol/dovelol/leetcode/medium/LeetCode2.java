package com.dove.lol.dovelol.leetcode.medium;

import java.util.Collections;

/**
 * @author Dovelol
 * @date 2018/4/22 22:36
 */
public class LeetCode2 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        ListNode listNodeTemp2 = null;
        for (int i = 0; i < 9; i++) {
            ListNode listNode = new ListNode(9);
            if (i == 0) {
                listNode.next = listNode2;
            } else {
                listNode.next = listNodeTemp2;
                listNodeTemp2 = listNode;
            }
        }
        ListNode listNode3 = addTwoNumbers(listNode1, listNodeTemp2);
        while (listNode3 != null){
            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }

//        System.out.println(addTwoNumbers(listNode1, listNode2).next.val);
//        System.out.println(addTwoNumbers(listNode1, listNode2).next.next.val);
//        System.out.println(addTwoNumbers(listNode1, listNode2).next.next.next.val);
//        System.out.println(addTwoNumbers(listNode1, listNode2).next.next.next.next.val);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0); // 头结点
        ListNode r = root;
        root.next = l1;

        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位

            r.next = p1;
            r = p1; // 指向最后一个相加的结点
            p1 = p1.next;
            p2 = p2.next;

        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }

        // 最后一次相加还有进位
        if (carry == 1) {
            // 开始时r.next是第一个要相加的结点
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // 都加完了还有进位，就要创建一个新的结点
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }

        return root.next;
    }

}
