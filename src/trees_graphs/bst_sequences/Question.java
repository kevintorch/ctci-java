package trees_graphs.bst_sequences;

import trees_graphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Question {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }

    static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.getData());

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.getLeft());
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.getRight());

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /* Weave lists together in all possible ways. This algorithm works by removing the
     * head from one list, recursing, and then doing the same thing with the other list. */
    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                   ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the head will damage
         * first, so we'll need to put it back where we found it afterwards.
         */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list. */
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
