package trees_graphs.common_ancestor;

import trees_graphs.TreeNode;

public class QuestionC {
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
        if (!covers(root, p) || !covers(root, q)) return null;
        return ancestorHelper(root, p, q);
    }

    public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;

        boolean pIsOnLeft = covers(root.getLeft(), p);
        boolean qIsOnLeft = covers(root.getLeft(), q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode newRoot = pIsOnLeft ? root.getLeft() : root.getRight();
        return ancestorHelper(newRoot, p, q);
    }

    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }
}
