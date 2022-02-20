package trees_graphs.in_order_successor;

// Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
// You may assume that each node has a link to its parent.

import trees_graphs.TreeNode;

public class Question {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int j : array) {
            TreeNode node = root.find(j);
            TreeNode next = inOrderSuccessor(node);
            if (next != null) {
                System.out.println(node.getData() + "->" + next.getData());
            } else {
                System.out.println(node.getData() + "->" + null);
            }
        }
    }

    public static TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) return null;

        if (node.getRight() != null) {
            return leftMostNode(node.getRight());
        } else {
            TreeNode current = node;
            TreeNode parent = current.getParent();
            while (parent != null && parent.getLeft() != current) {
                parent = parent.getParent();
                current = parent;
            }
            return parent;
        }
    }

    private static TreeNode leftMostNode(TreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
