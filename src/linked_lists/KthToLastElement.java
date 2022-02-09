package linked_lists;

// Implement an algorithm to find the kth to last element of a singly linked list.

public class KthToLastElement {
    public static void main(String[] args) {
        LinkedList.Node list = LinkedList.createFromArray(new Integer[]{23, 34, 3, 4, 5, 24, 11, 77});
        LinkedList.printList(list);
        LinkedList.Node node = kthToLast(list, 1);
        LinkedList.printList(node);
    }

    // My Way.. Making Runner Node ahead of k times ahead of first node.
    // Mistake: I was Running second node for every move of the first. What I should've done is that make runner node
    // move k times then move both nodes simultaneously.
    public static LinkedList.Node kthToLastElement(LinkedList.Node head, int k) {
        LinkedList.Node runnerNode = head;
        LinkedList.Node node = head;
        while (runnerNode.next() != null) {
            int i = 0;
            while (runnerNode.next() != null && i < k) {
                runnerNode = runnerNode.next();
                i++;
            }
            node = node.next();
        }
        return node;
    }

    public static LinkedList.Node kthToLastElementCorrection(LinkedList.Node head, int k) {
        LinkedList.Node runnerNode = head;
        LinkedList.Node node = head;

        int i = 0;
        while (i < k) {
            if (runnerNode == null) return null;
            runnerNode = runnerNode.next();
            i++;
        }
        while (runnerNode != null) {
            runnerNode = runnerNode.next();
            node = node.next();
        }
        return node;
    }

    public static int printKthToLastElementRecurrence(LinkedList.Node head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLastElementRecurrence(head.next(), k) + 1;
        if (index == k) {
            System.out.println(head);
        }
        return index;
    }

    public static LinkedList.Node kthToLast(LinkedList.Node head, int k) {
        Index in = new Index();
        return kthToLastElementRecurrence(head, k, in);
    }

    public static LinkedList.Node kthToLastElementRecurrence(LinkedList.Node head, int k, Index index) {
        if (head == null) return null;

        LinkedList.Node node = kthToLastElementRecurrence(head.next(), k, index);
        index.value += 1;
        if (index.value == k) return head;
        return node;
    }

    public static LinkedList.Node kthToLastElementRecurrence2(LinkedList.Node head, int k, IndexNode indexNode) {
        if (head == null) return null;

        indexNode.node = kthToLastElementRecurrence2(head.next(), k, indexNode);
        indexNode.value++;
        if (indexNode.value == k) {
            indexNode.node = head;
        }
        return indexNode.node;
    }

    static class Index {
        int value = 0;
    }

    static class IndexNode {
        int value = 0;
        LinkedList.Node node;
    }


}
