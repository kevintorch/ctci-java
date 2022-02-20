package trees_graphs.common_ancestor;

import trees_graphs.TreeNode;

public class QuestionB {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(2);
        TreeNode n7 = root.find(10);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        if (ancestor != null)
            System.out.println(ancestor.getData());
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) { // Nodes are not present in the tree.
            return null;
        } else if (covers(p, q)) { // p is ancestor of q.
            return p;
        } else if (covers(q, p)) { // q is ancestor of p.
            return q;
        }

        // then q must be present in p's sibling subtree.
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.getParent();
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.getParent();
        }
        return parent;
    }

    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }

    public static TreeNode getSibling(TreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }

        TreeNode parent = node.getParent();
        return parent.getLeft() == node ? parent.getRight() : parent.getLeft();
    }
}
