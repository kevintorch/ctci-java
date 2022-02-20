package trees_graphs.check_balanced;

//  Implement a function to check if a binary tree is balanced.
//  For the purposes of this question, a balanced tree is defined to be a tree
//  such that the heights of the two subtrees of any node never differ by more than one.

import trees_graphs.TreeNode;

public class Question {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return false;

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    public static boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
}
