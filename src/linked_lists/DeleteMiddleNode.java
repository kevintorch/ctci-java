package linked_lists;

// Implement an algorithm to delete a node in the middle
// (i.e., any node but the first and last node, not necessarily the exact middle)
// of a singly linked list, given only access to that node.
//
// EXAMPLE
// Input: the node c from the linked list a->b->c->d->e->f
// Result: nothing is returned, but the new linked list looks like a->b->d->e->f

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList.Node alphabets = LinkedList.createFromArray(new Character[]{'a', 'b', 'c', 'd', 'e', 'f'});

        LinkedList.printList(alphabets);

        LinkedList.Node kthToLast = KthToLastElement.kthToLast(alphabets, 4);
        LinkedList.printList(kthToLast);

        deleteMiddle(kthToLast);

        LinkedList.printList(alphabets);
    }

    // One Problem: You Cannot delete last node.
    public static boolean deleteMiddle(LinkedList.Node middleNode) {
        if (middleNode == null || middleNode.next() == null) return false;
        middleNode.setValue(middleNode.next().getValue());
        middleNode.setNext(middleNode.next().next());
        return true;
    }
}
