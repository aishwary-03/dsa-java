package com.dsa.patterns.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, node4);
        ListNode node1 = new ListNode(1, node2);
        ListNode list1 =node1;
        System.out.println("List 1 ::: ");
        while (list1 !=null) {
            System.out.println(list1.val);
            list1 = list1.next;
        }
        list1 = node1;

        ListNode anotherNode4 = new ListNode(4);
        ListNode node3 = new ListNode(3, anotherNode4);
        ListNode anotherNode1 = new ListNode(1, node3);
        ListNode list2 = anotherNode1;
        System.out.println("List 2 ::: ");
        while (list2 !=null) {
            System.out.println(list2.val);
            list2 = list2.next;
        }
        list2 = anotherNode1;

        ListNode merged = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        System.out.println("Merged:::");
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

       if (list1 != null) {
           head.next = list1;
       } else {
           head.next  = list2;
       }
        return dummy.next;
    }

}
