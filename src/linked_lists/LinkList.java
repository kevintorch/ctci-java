package linked_lists;

public class LinkList {

    private Node root;
    private int size;


    public static Node deleteNode(Node root, Object value) {
        Node node = root;

        if (root.value.equals(value)) {
            Node next = root.next;
            next.previous = null;
            return next;
        }
        node = node.next;
        while (node != null) {
            if (node.value.equals(value)) {
                if (node.next != null) {
                    node.next.previous = node.previous;
                }
                if (node.previous != null) {
                    node.previous.next = node.next;
                }
                node.previous = null;
                node.next = null;
                break;
            }
            node = node.next;
        }

        return root;
    }


    static class Node {
        private final Object value;
        private Node next;
        private Node previous;

        public Node(Object value) {
            this.value = value;
        }

        public void appendToTail(Object value) {
            Node node = new Node(value);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }
}
