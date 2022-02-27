package trees_graphs.validate_bst;

// Implement a function to check if a binary tree is a binary search tree.

import trees_graphs.TreeNode;

public class Question {

    static int index = 0;
    static Integer last_printed = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(1));
        System.out.println("is BST: " + checkBST2(root));
    }

    public static boolean isBST(TreeNode root) {
        int[] array = new int[root.size()];
        copyBST(root, array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) return false;
        }
        return true;
    }

    public static void copyBST(TreeNode node, int[] array) {
        if (node == null) return;
        copyBST(node.getLeft(), array);
        array[index] = node.getData();
        index++;
        copyBST(node.getRight(), array);
        index = 0;
    }

    public static boolean checkBST(TreeNode root) {
        if (root == null) return true;

        if (!checkBST(root.getLeft())) return false;

        if (last_printed != null && root.getData() <= last_printed)
            return false;

        last_printed = root.getData();

        return checkBST(root.getRight());
    }

    public static boolean checkBST2(TreeNode root) {
        return checkBST2(root, null, null);
    }

    private static boolean checkBST2(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max)) {
            return false;
        }

        return checkBST2(root.getLeft(), min, root.getData()) && checkBST2(root.getRight(), root.getData(), max);
    }
}
