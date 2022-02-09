package linked_lists;

// You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order,such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
//
// EXAMPLE
// Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
// Output: 2 -> 1 -> 9. That is,912.
//
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
// Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
// Output: 9 -> 1 -> 2. That is, 912.

public class SumLists {
    public static void main(String[] args) {
        LinkedList.Node list1 = LinkedList.createReverseList(37);
        LinkedList.printList(list1);
        LinkedList.Node list2 = LinkedList.createReverseList(4245);
        LinkedList.printList(list2);

    }

    // Wrong My Way.
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

    public static LinkedList.Node sumLists2(LinkedList.Node n1, LinkedList.Node n2) {
        return sumListsRecurrence(n1, n2, 0);
    }

    private static LinkedList.Node sumListsRecurrence(LinkedList.Node n1, LinkedList.Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) return null;

        int sum = carry;
        if (n1 != null)
            sum += (int) n1.getValue();
        if (n2 != null)
            sum += (int) n2.getValue();

        LinkedList.Node node = new LinkedList.Node(sum % 10);
        LinkedList.Node sumList = sumListsRecurrence(n1 != null ? n1.next() : null, n2 != null ? n2.next() : null, sum / 10);

        node.setNext(sumList);
        return node;
    }

    private static LinkedList.Node sumListsRecurrenceReverse(LinkedList.Node n1, LinkedList.Node n2) {
        int len1 = LinkedList.length(n1);
        int len2 = LinkedList.length(n2);

        if (len1 < len2) {
            n1 = padList(n1, len2 - len1);
        } else {
            n2 = padList(n2, len1 - len2);
        }

        PartialSum sum = addListsHelper(n1, n2);

        if (sum.carry > 0) {
            return insertBefore(sum.node, sum.carry);
        }

        return sum.node;
    }

    private static PartialSum addListsHelper(LinkedList.Node n1, LinkedList.Node n2) {
        if (n1 == null && n2 == null) return new PartialSum();

        PartialSum sum = addListsHelper(n1 != null ? n1.next() : null, n2 != null ? n2.next() : null);

        int value = sum.carry;
        if (n1 != null)
            value += (int) n1.getValue();
        if (n2 != null)
            value += (int) n2.getValue();

        sum.node = insertBefore(sum.node, value % 10);
        sum.carry = value / 10;
        return sum;
    }

    private static LinkedList.Node padList(LinkedList.Node list, int times) {
        if (times <= 0) return list;
        LinkedList.Node node = insertBefore(list, 0);
        return padList(node, --times);
    }

    private static LinkedList.Node insertBefore(LinkedList.Node list, Object value) {
        LinkedList.Node node = new LinkedList.Node(value);
        node.setNext(list);
        return node;
    }

    static class PartialSum {
        LinkedList.Node node;
        int carry;
    }
}
