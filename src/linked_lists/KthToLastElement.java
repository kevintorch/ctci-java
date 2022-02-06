package linked_lists;

// Implement an algorithm to find the kth to last element of a singly linked list.

public class KthToLastElement {
    public static void main(String[] args) {

    }

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

    public static LinkedList.Node kthToLastElementRecurr(LinkedList.Node head, int k) {
        int i = 0;
        LinkedList.Node runnerNode = head;
        while (runnerNode.next() != null && i < k) {
            runnerNode = runnerNode.next();
            i++;
        }
        if (head.next() == null) return head;
        else return kthToLastElementRecurr(runnerNode, k);
    }
}
