package linked_lists;

// Write code to partition a linked list around a value x,
// such that all nodes less than x come before all nodes greater than or equal to x.
// If x is contained within the list the values of x only need to be after the elements less than x (see below).
// The partition element x can appear anywhere in the "right partition";
// it does not need to appear between the left and right partitions.
//
// EXAMPLE
// Input: 3 -> 5 -> 8 --> 5 -> 10 --> 2 --> 1 [partition=5]
// Output: 3 -> 1 --> 2 -> 10 -> 5 --> 5 -> 8

import helpers.ArrayUtil;

public class Partition {
    public static void main(String[] args) {
        Integer[] partitionArray = {3, 5, 8, 5, 10, 2, 1};
        ArrayUtil.print(partitionArray);
//        ArrayUtil.reverse(partitionArray, 0, partitionArray.length);
//        ArrayUtil.print(partitionArray);
        LinkedList.Node head = LinkedList.createFromArray(partitionArray);
//        LinkedList.Node partitionList = LinkedList.createFromArray(partitionArray);
        LinkedList.printList(head);
        LinkedList.Node partition = partition(head, 5);
        LinkedList.printList(partition);
        LinkedList.Node head2 = LinkedList.createFromArray(partitionArray);
        LinkedList.Node partitionInPlace = partitionInPlace(head2, 5);
        LinkedList.printList(partitionInPlace);
    }

    // With Two extra List to hold lesser and greater elements.
    // TODO:- Fix Bugs
    public static LinkedList.Node partition(LinkedList.Node head, int x) {
        LinkedList.Node beforeStart = null;
        LinkedList.Node beforeEnd = null;
        LinkedList.Node afterStart = null;
        LinkedList.Node afterEnd = null;

        /* Partition list */
        while (head != null) {
            LinkedList.Node next = head.next();
            head.setNext(null);

            int headValue = (int) head.getValue();
            if (headValue < x) {
                /* Insert node into end of before list */
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.setNext(head);
                    beforeEnd = head;
                }
            } else {
                /* Insert node into end of after list */
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.setNext(head);
                    afterEnd = head;
                }
            }

            head = next;
        }

        if (beforeStart == null) return afterStart;

        /* Merge before list and after list */
        beforeEnd.setNext(afterStart);
        return beforeStart;
    }

    // Without Extra buffer (or within a list)
    // TODO:- Fix Bugs
    public static LinkedList.Node partitionInPlace(LinkedList.Node node, int x) {
        LinkedList.Node head = node;
        LinkedList.Node tail = node;

        while (node != null) {
            LinkedList.Node next = node.next();
            int value = (int) node.getValue();
            if (value < x) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        if (tail != null) {
            tail.setNext(null);
        }

        return head;
    }

}
