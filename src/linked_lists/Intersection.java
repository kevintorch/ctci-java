package linked_lists;

// Given two (singly) linked lists, determine if the two lists intersect.
// Return the intersecting node.
// Note that the intersection is defined based on reference, not value.
// That is, if the kth node of the first linked list is the exact same node
// (by reference) as the jth node of the second linked list, then they are intersecting.

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        Integer[] array1 = {1, 12, 3, 10, 2, 43, 2, 1};
        LinkedList.Node list1 = LinkedList.createFromArray(array1);
        LinkedList.Node list2 = LinkedList.createReverseList(324);


        list2.next().setNext(list1.next().next().next().next());
//        list2.appendToTail(list1.next().next().next().next());

        LinkedList.printList(list1);
        LinkedList.printList(list2);

        LinkedList.Node intersectingNode = isIntersecting2(list1, list2);

        System.out.println("Intersecting Node is");

        LinkedList.printList(intersectingNode);

        LinkedList.Node node = kthNode(list1, 4);
        LinkedList.printList(node);

    }

    // With Hash Table.
    public static LinkedList.Node isIntersecting(LinkedList.Node list1, LinkedList.Node list2) {
        Set<LinkedList.Node> nodes = new HashSet<>();
        LinkedList.Node l1 = list1;
        LinkedList.Node l2 = list2;
        while (l1 != null) {
            nodes.add(l1);
            l1 = l1.next();
        }

        while (l2 != null) {
            if (nodes.contains(l2)) {
                return l2;
            }
            l2 = l2.next();
        }

        return null;
    }

    // With Last Node Comparison.
    public static LinkedList.Node isIntersecting2(LinkedList.Node list1, LinkedList.Node list2) {
        if (list1 == null || list2 == null) return null;
        NodeInfo list1Info = getTailAndSize(list1);
        NodeInfo list2Info = getTailAndSize(list2);

        if (list1Info.tail != list2Info.tail) return null;

        LinkedList.Node shorter = list1Info.size < list2Info.size ? list1 : list2;
        LinkedList.Node longer = list1Info.size < list2Info.size ? list2 : list1;

        longer = kthNode(longer, Math.abs(list1Info.size - list2Info.size));

        while (longer != shorter) {
            longer = longer.next();
            shorter = shorter.next();
        }

        return longer;
    }

    private static LinkedList.Node kthNode(LinkedList.Node node, int k) {
        if (k <= 0) return node;
        return kthNode(node.next(), --k);
    }

    private static NodeInfo getTailAndSize(LinkedList.Node head) {
        if (head == null) return null;
        LinkedList.Node n = head;
        int i = 1;
        while (n.next() != null) {
            i++;
            n = n.next();
        }
        return new NodeInfo(n, i);
    }

    private static class NodeInfo {
        LinkedList.Node tail;
        int size;

        public NodeInfo(LinkedList.Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
