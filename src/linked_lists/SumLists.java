package linked_lists;

// You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order,such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
//
// EXAMPLE
// Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
// Output: 2 -> 1 -> 9. That is,912.

public class SumLists {
    public static void main(String[] args) {

    }

    public static LinkedList.Node sumLists(LinkedList.Node node1, LinkedList.Node node2) {
        LinkedList.Node head = null;
        LinkedList.Node tail = null;

        LinkedList.Node head1 = node1;
        LinkedList.Node head2 = node2;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int head1Value = 0;
            int head2Value = 0;
            if (head1 != null) {
                head1Value = (int) head1.getValue();
            }
            if (head2 != null) {
                head2Value = (int) head2.getValue();
            }
            int sum = head1Value + head2Value + carry;
            LinkedList.Node sumNode = new LinkedList.Node(sum / 2);
            carry = sum % 2;
            if (head == null) {
                head = sumNode;
                tail = head;
            } else {
                tail.setNext(sumNode);
                tail = sumNode;
            }

            if (head1 != null) {
                head1 = head1.next();
            }
            if (head2 != null) {
                head2 = head2.next();
            }
        }
        if (carry != 0) {
            LinkedList.Node node = new LinkedList.Node(carry);
            tail.setNext(node);
            tail = node;
        }
        if (tail != null) {
            tail.setNext(null);
        }

        return head;
    }

//    public static LinkedList.Node sumLists2(LinkedList.Node n1, LinkedList.Node n2) {
//        return sumListsRecurrence(n1, n2, 0);
//    }
//
//    public static LinkedList.Node sumListsRecurrence(LinkedList.Node n1, LinkedList.Node n2, int carry) {
//        int n1Value = (int) n1.getValue();
//        int n2Value = (int) n2.getValue();
//
//        int sum = n1Value + n2Value + carry;
//        LinkedList.Node sumNode = new LinkedList.Node(sum / 2);
//
//        return sumListsRecurrence(n1.next(), n2.next(), sum % 2);
//    }
}
