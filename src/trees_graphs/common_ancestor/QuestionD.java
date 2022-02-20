package trees_graphs.common_ancestor;

import trees_graphs.TreeNode;

public class QuestionD {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(11);
        TreeNode n7 = root.find(22);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        if (ancestor != null)
            System.out.println(ancestor.getData());
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = commonAncestorHelper(root, p, q);
        return result.isAncestor ? result.node : null;
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return Result.NOT_FOUND;
        if (root == p && root == q)
            return Result.found(root);

        Result rx = commonAncestorHelper(root.getLeft(), p, q);
        if (rx.isAncestor) return rx;  //Found common ancestor

        Result ry = commonAncestorHelper(root.getRight(), p, q);
        if (ry.isAncestor) return rx;  //Found common ancestor

        if (rx.node != null && ry.node != null) {
            return Result.found(root);  // This is the common ancestor
        } else if (root == p || root == q) {
            /* If we're currently at p or q, and we also found one of those nodes in a
             * subtree, then this is truly an ancestor and the flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        }

        return new Result(rx.node != null ? rx.node : ry.node, false);
    }

    static class Result {
        public static final Result NOT_FOUND = new Result(null, false);
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }

        public static Result found(TreeNode node) {
            return new Result(node, true);
        }
    }
}
