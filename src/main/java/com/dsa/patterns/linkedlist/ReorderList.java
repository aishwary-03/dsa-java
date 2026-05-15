package com.dsa.patterns.linkedlist;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reorderList.reorderList(node1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;

        ListNode second = null;
        ListNode current = list2;
        while (current != null) {
            ListNode next = current.next;
            current.next = second;
            second = current;
            current = next;
        }

        ListNode first = head;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }


}
