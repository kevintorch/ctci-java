package trees_graphs.check_subtree;

// T1 and T2 are two very large binary trees, with T1 much bigger than T2.
// Create an algorithm to determine if T2 is a subtree of T1.\
//
// A tree T2 is a subtree of T1 if there exists a node n in T1
// such that the subtree of n is identical to T2. That is,
// if you cut off the tree at node n, the two trees would be identical.

import trees_graphs.TreeNode;

public class QuestionB {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // We needed this code for other files, so check out the code in the library
        TreeNode root = TreeNode.createMinimalBST(array);
        int[] sample = {7, 2, 5};
        final TreeNode node = TreeNode.createMinimalBST(sample);
//        final TreeNode matchingNode = findMatchingNode(root, 11);
//        if (matchingNode != null)
//            System.out.println("Node: " + matchingNode.getData());
        System.out.println("is Subtree: " + contains(root, node));
    }

    public static boolean contains(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true; // empty tree is always a subtree.
        return subtree(t1, t2);
    }

    private static boolean subtree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false; // big tree empty & subtree still not found.
        } else if (r1.getData() == r2.getData() && matchTree(r1, r2)) {
            return true;
        }
        return subtree(r1.getLeft(), r2) || subtree(r1.getRight(), r2);
    }

    private static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true; // nothing left in the subtree
        } else if (r1 == null || r2 == null) {
            return false; // exactly tree is empty, therefore trees don't match
        } else if (r1.getData() != r2.getData()) {
            return false;  // data doesn't match.
        } else {
            return matchTree(r1.getLeft(), r2.getLeft()) && matchTree(r1.getRight(), r2.getRight());
        }
    }

}
