package linked_lists;

// Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

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

    public static class Node {
        private Object value;
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

        public void setValue(Object value) {
            this.value = value;
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
