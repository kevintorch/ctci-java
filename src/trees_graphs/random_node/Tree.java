package trees_graphs.random_node;

import trees_graphs.TreeNode;

import java.util.Random;

public class Tree {
    private TreeNode root = null;


    public void insertInOrder(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;
        Random random = new Random();
        int index = random.nextInt(root.size());
        return root.getIthNode(index);
    }
}
