package trees_graphs;

public class TreeNode {
    private final int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int size;

    public TreeNode(int data) {
        this.data = data;
        size = 1;
    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);

        n.setLeft(createMinimalBST(array, start, mid - 1));
        n.setRight(createMinimalBST(array, mid + 1, end));
        return n;
    }

    public void insertInOrder(int d) {
        TreeNode treeNode = new TreeNode(d);
        if (d <= data) {
            if (left == null)
                left = treeNode;
            else left.insertInOrder(d);
        } else {
            if (right == null) {
                right = treeNode;
            } else right.insertInOrder(d);
        }
        size++;
    }

    public boolean isBST() {
        if (left != null && (left.data > data || !left.isBST())) {
            return false;
        }

        return right == null || (right.data > data && right.isBST());
    }

    public TreeNode find(int d) {
        if (data == d) return this;
        if (d <= data) {
            return left != null ? left.find(d) : null;
        }
        return right != null ? right.find(d) : null;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int size() {
        return size;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (left != null)
            left.parent = this;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (right != null)
            right.parent = this;
    }

    public TreeNode getParent() {
        return parent;
    }


}
