package helpers;

import trees_graphs.TreeNode;

public class TreeUtil {

    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = queue.element();
                if (r.getLeft() == null) {
                    r.setLeft(new TreeNode(array[i]));
                    i++;
                    queue.add(r.getLeft());
                } else if (r.getRight() == null) {
                    r.setRight(new TreeNode(array[i]));
                    i++;
                    queue.add(r.getRight());
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }
}
