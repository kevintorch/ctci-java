package trees_graphs.common_ancestor;

import trees_graphs.TreeNode;

// Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
// Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(4);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(n3, n7);
        if (ancestor != null)
            System.out.println(ancestor.getData());
    }

    static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        final int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p; // get shallower node.
        TreeNode second = delta > 0 ? p : q; // get deeper node.

        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.getParent();
            second = second.getParent();
        }

        return first == null || second == null ? null : first;
    }

    static TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.getParent();
            delta--;
        }
        return node;
    }

    static int depth(TreeNode n) {
        int depth = 0;
        TreeNode node = n;
        while (node != null) {
            depth++;
            node = node.getParent();
        }
        return depth;
    }
}
