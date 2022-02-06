package linked_lists;

// Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

import java.util.HashSet;

public class LinkedList {

    public static Node deleteNode(Node head, Object d) {
        Node n = head;

        if (n.value == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.value == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    public static void removeDuplicates(Node node) {
        HashSet<Node> hashTable = new HashSet<>();

        Node prev = null;
        while (node != null) {
            if (hashTable.contains(node)) {
                prev.next = node.next;
            } else {
                hashTable.add(node);
                prev = node;
            }
            node = node.next;
        }
    }

    public static void deleteDuplicates(Node head) {

    }

    public static class Node {
        private final Object value;
        private Node next = null;

        public Node(Object value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node next() {
            return next;
        }

        public Object getValue() {
            return value;
        }

        void appendToTail(Object data) {
            Node tail = new Node(data);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = tail;
        }
    }
}
