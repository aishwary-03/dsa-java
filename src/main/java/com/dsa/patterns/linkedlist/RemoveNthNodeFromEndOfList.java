package com.dsa.patterns.linkedlist;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1);
        ListNode removedNthFromEnd = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 1);
        while (removedNthFromEnd != null) {
            System.out.println(removedNthFromEnd.val);
            removedNthFromEnd = removedNthFromEnd.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        int elementToRemove = length - n;

        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode removed = dummy;
        while (dummy != null) {
            if (count == elementToRemove) {
                dummy.next = dummy.next.next;
                break;
            }
            count++;
            dummy = dummy.next;
        }

        return removed.next;

    }

}
