package helpers;

import linked_lists.LinkedList;

public class ListUtil {

    public static LinkedList.Node reverse(LinkedList.Node head) {
        if (head == null) return null;
        LinkedList.Node next = head.next();
        head.setNext(null);
        LinkedList.Node n = reverse(next);
        if (n != null) {
            n.appendToTail(head);
        }
        return n == null ? head : n;
    }

    public static LinkedList.Node reverseItr(LinkedList.Node head) {
        if (head == null) return null;
        LinkedList.Node node = head.next();
        head.setNext(null);
        while (node != null) {
            LinkedList.Node next = node.next();
            node.setNext(head);
            head = node;
            node = next;
        }
        return head;
    }

//    public static LinkedList.Node reverseRec(LinkedList.Node head) {
//        if (head == null) return null;
//        LinkedList.Node node = head.next();
//        head.setNext(null);
//        LinkedList.Node n = reverseHelper(head, node);
//        if (n != null)
//            n.setNext(head);
//        return n == null ? head : n;
//    }
//
//    public static LinkedList.Node reverseHelper(LinkedList.Node head, LinkedList.Node node) {
//        if (node == null) return null;
//        LinkedList.Node next = node.next();
//        node.setNext(head);
//        return reverseHelper(node, next);
//    }
}
