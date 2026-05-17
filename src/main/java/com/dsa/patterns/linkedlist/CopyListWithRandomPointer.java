package com.dsa.patterns.linkedlist;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = n2;


        Node copiedHead = copyListWithRandomPointer.copyRandomList(n1);

        System.out.println("Original List:");
        printList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }

    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {

            int randomVal =
                    (curr.random != null)
                            ? curr.random.val
                            : -1;

            System.out.println(
                    "Node = " + curr.val +
                            ", Random = " + randomVal
            );

            curr = curr.next;
        }
    }

    Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
           if (curr.random != null) {
               curr.next.random = curr.random.next;
           }
           curr = curr.next.next;
        }

        curr = head;

        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }
        return dummy.next;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}