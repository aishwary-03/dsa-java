package com.dsa.patterns.dailyquestion;

import com.dsa.patterns.linkedlist.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {

    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList deleteTheMiddleNodeOfALinkedList = new DeleteTheMiddleNodeOfALinkedList();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(7);
        ListNode fifth = new ListNode(1);
        ListNode sixth = new ListNode(2);

        sixth.next = new ListNode(6);
        fifth.next = sixth;
        fourth.next = fifth;
        third.next = fourth;
        second.next = third;
        head.next = second;

        System.out.println(deleteTheMiddleNodeOfALinkedList.deleteMiddle(head));
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
