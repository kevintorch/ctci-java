package trees_graphs.minimal_tree;

// Given a sorted (increasing order) array with unique integer elements,
// write an algorithm to create a binary search tree with minimal height.

import trees_graphs.TreeNode;

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // We needed this code for other files, so check out the code in the library
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.getData());
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }
}
