package linked_lists;

import java.util.HashSet;
import java.util.Set;

// Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

public class RemoveDuplicates {
    public static void main(String[] args) {
        Integer[] array = {12, 33, 1, 2, 33, 50, 1, 23};
        LinkedList.Node unsortedList = LinkedList.createFromArray(array);
        LinkedList.printList(unsortedList);
        removeDuplicates2(unsortedList);
        LinkedList.printList(unsortedList);
    }

    public static void removeDuplicates(LinkedList.Node head) {
        Set<Object> hashTable = new HashSet<>();
        LinkedList.Node previous = null;
        while (head != null) {
            if (hashTable.contains(head.getValue())) {
                previous.setNext(head.next());
            } else {
                hashTable.add(head.getValue());
                previous = head;
            }
            head = head.next();
        }
    }

    // Without memory. TODO:- Fix Bug.
    public static void removeDuplicates2(LinkedList.Node head) {
        LinkedList.Node headNode = head;
        while (headNode != null) {
            LinkedList.Node runner = headNode;
            while (runner.next() != null) {
                if (runner.next() == headNode) {
                    runner.next().setNext(runner.next().next());
                } else {
                    runner = runner.next();
                }
            }
            headNode = headNode.next();
        }
    }
}
