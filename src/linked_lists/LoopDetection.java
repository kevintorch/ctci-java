package linked_lists;

// Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
// so as to make a loop in the linked list.

// EXAMPLE: 1 -> 3 -> 23 -> 45 -> 34 -> 50 -> 23

public class LoopDetection {
    public static void main(String[] args) {
        LinkedList.Node simpleList = LinkedList.createFromArray(new Integer[]{1, 3, 23, 45, 34, 50});
        System.out.println("Simple List");
        LinkedList.printList(simpleList);

        LinkedList.Node kth = kthNode(simpleList, 3);
        LinkedList.printList(kth);

        simpleList.appendToTail(kth);

        LinkedList.Node node = containLoop(simpleList);
        System.out.println("SimpleList contains Loop: ");
        LinkedList.printList(node);

    }

    private static LinkedList.Node kthNode(LinkedList.Node head, int k) {
        if (k <= 0) return head;
        return kthNode(head.next(), --k);
    }

    public static LinkedList.Node containLoop(LinkedList.Node head) {
        LinkedList.Node slowNode = head;
        LinkedList.Node fastNode = head;

        while (fastNode != null && fastNode.next() != null) {
            slowNode = slowNode.next();
            fastNode = fastNode.next().next();
            if (fastNode == slowNode) break;
        }

        if (fastNode == null || fastNode.next() == null) {
            return null;
        }
        slowNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next();
            fastNode = fastNode.next();
        }
        fastNode.setNext(null);
        return fastNode;
    }
}
