package hard.Q12_BiNode;

// Consider a simple data structure called BiNode, which has pointers to two other nodes.
// The data structure BiNode could be used to represent both a binary tree
// (where node1 is the left node and node2 is the right node) or a doubly linked list
// (where node1 is the previous node and node2 is the next node).
// Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list.
// The values should be kept in order and the operation should be performed in place (that is, on the original data
// structure).
public class Question {
    public static void main(String[] args) {

    }

    private static NodePair convert(BiNode root) {
        if (root == null) return null;
        NodePair part1 = convert(root.node1);
        NodePair part2 = convert(root.node2);

        if (part1 != null) {
            concat(part1.tail, root);
        }

        if (part2 != null) {
            concat(root, part2.head);
        }

        return new NodePair(part1 != null ? part1.head : root, part2 != null ? part2.tail : root);
    }

    private static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

    private static class NodePair {
        BiNode head;
        BiNode tail;

        public NodePair(BiNode head, BiNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
