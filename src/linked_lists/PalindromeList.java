package linked_lists;

// Implement a function to check if a linked list is a palindrome.

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PalindromeList {
    public static void main(String[] args) {
        LinkedList.Node list1 = LinkedList.createReverseList(1323);
        LinkedList.Node list2 = LinkedList.createReverseList(1331);

        LinkedList.Node list3 = LinkedList.createReverseList(13);
        LinkedList.Node list4 = LinkedList.createReverseList(11);

        LinkedList.Node list5 = LinkedList.createReverseList(0);

        LinkedList.printList(list1);

        list1 = reverseList(list1);

        LinkedList.printList(list1);
    }

    // My Solution: Simple With Queue.
    public static boolean isPalindrome(LinkedList.Node head) {
        Queue<Integer> integers = new ConcurrentLinkedQueue<>();
        isPalindrome(head, integers);
        return integers.isEmpty();
    }

    private static void isPalindrome(LinkedList.Node head, Queue<Integer> integers) {
        if (head == null) return;
        integers.add((Integer) head.getValue());
        isPalindrome(head.next(), integers);
        Integer peek = integers.peek();
        if (peek != null && ((int) head.getValue()) == peek) {
            integers.poll();
        }
    }

    /**
     * With Reverse and Compare Technique
     *
     * @return true, if list is a palindrome list.
     */
    public static boolean isPalindrome2(LinkedList.Node head) {
        LinkedList.Node second = reverseList(head);
        return isEqual(head, second);
    }

    private static LinkedList.Node reverseList(LinkedList.Node head) {
        LinkedList.Node l2 = null;
        while (head != null) {
            LinkedList.Node n = new LinkedList.Node(head.getValue());
            n.setNext(l2);
            l2 = n;
            head = head.next();
        }
        return l2;
    }

    private static boolean isEqual(LinkedList.Node list1, LinkedList.Node list2) {
        while (list1 != null && list2 != null) {
            if (!list1.getValue().equals(list2.getValue())) return false;
            list1 = list1.next();
            list2 = list2.next();
        }
        return list1 == list2;
    }


    /**
     * with iterative approach. Uses Stack.
     *
     * @return
     */
    public static boolean isPalindrome3(LinkedList.Node head) {
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;

        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next() != null) {
            stack.push((Integer) slow.getValue());
            slow = slow.next();
            fast = fast.next().next();
        }

        /* Has odd number of elements, so skip the middle element. */
        if (fast != null) {
            slow = slow.next();
        }

        while (slow != null) {
            if (stack.pop() != ((int) slow.getValue())) {
                return false;
            }
            slow = slow.next();
        }

        return true;
    }


    /**
     * with Recursive Approach.
     *
     * @return
     */
    public static boolean isPalindrome4(LinkedList.Node head) {
        int length = LinkedList.length(head);
        return isPalindromeRecurse(head, length).result;
    }

    private static Result isPalindromeRecurse(LinkedList.Node head, int length) {
        if (head == null || length == 0) return new Result(head, true);
        else if (length == 1) return new Result(head.next(), true);

        Result result = isPalindromeRecurse(head.next(), length - 2);

        if (!result.result || result.node == null) return result;

        result.result = (head.getValue() == result.node.getValue());
        result.node = result.node.next();

        return result;
    }

    private static class Result {
        LinkedList.Node node;
        boolean result;

        public Result(LinkedList.Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

}
