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

    public static int length(Node head) {
        Node n = head;
        int sum = 0;
        while (n != null) {
            sum++;
            n = n.next();
        }
        return sum;
    }

    public static LinkedList.Node createFromArray(Object[] array) {
        LinkedList.Node head = null;
        for (Object e : array) {
            Node node = new Node(e);
            if (head == null) {
                head = node;
            } else {
                head.appendToTail(node);
            }
        }
        return head;
    }

    public static LinkedList.Node createReverseList(int number) {
        if (number <= 9) return new LinkedList.Node(number);
        int lastDigit = number % 10;
        LinkedList.Node lastDigitNode = new LinkedList.Node(lastDigit);
        LinkedList.Node list = createReverseList(number / 10);
        list.appendToTail(lastDigitNode);
        return list;
    }

    public static LinkedList.Node createList(int number) {
        if (number <= 9) return new LinkedList.Node(number);
        int leastDigit = number % 10;
        LinkedList.Node node = new LinkedList.Node(leastDigit);
        LinkedList.Node lastNode = createList(number / 10);
        node.setNext(lastNode);
        return node;
    }

    public static void printList(Node head) {
        Node n = head;
        StringBuilder listString = new StringBuilder();
        while (n != null) {
            Node next = n.next();
            listString.append(n.getValue());
            if (next != null) {
                listString.append("-->");
            }
            n = next;
        }
        System.out.println(listString);
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

        public void appendToTail(Node tail) {
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = tail;
        }
    }
}
