package com.dsa.patterns.dailyquestion;

import com.dsa.patterns.linkedlist.ListNode;

public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList = new MaximumTwinSumOfALinkedList();
        ListNode root = new ListNode(1);

        root.next = new ListNode(100000);
        System.out.println(maximumTwinSumOfALinkedList.pairSum(root));
    }

    public int pairSum(ListNode head) {
        int maxTwinSum = Integer.MIN_VALUE;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);

        while (reversed != null && head != null) {
            maxTwinSum = Math.max(maxTwinSum, head.val + reversed.val);
            head = head.next;
            reversed = reversed.next;
        }
        return maxTwinSum;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
