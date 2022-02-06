package linked_lists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {

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

    // Without memory.
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
