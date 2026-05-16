package com.dsa.patterns.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2);
        four.next = two;
        ListNode head = new ListNode(1, two);
        two.next = head;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> traversed = new HashSet<>();

        while (head != null) {
            if (traversed.contains(head)) {
                return true;
            }
            traversed.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleWithoutSet(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast.next = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
