package trees_graphs.paths_with_sum;

// You are given a binary tree in which each node contains an integer value (which might be positive or negative).
// Design an algorithm to count the number of paths that sum to a given value.
// The path does not need to start or end at the root or a leaf,
// but it must go downwards (traveling only from parent nodes to child nodes).

import trees_graphs.TreeNode;

public class QuestionA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.setLeft(new TreeNode(0));
        root.setRight(new TreeNode(0));
        root.getRight().setLeft(new TreeNode(0));
        root.getRight().getLeft().setRight(new TreeNode(0));
        root.getRight().setRight(new TreeNode(0));
        System.out.println(countPathsWithSum(root, 0));
        System.out.println(countPathsWithSum(root, 4));
    }


    public static int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int rootSum = countPathsWithSumFromNode(root, targetSum, 0);

        rootSum += countPathsWithSum(root.getLeft(), targetSum);
        rootSum += countPathsWithSum(root.getRight(), targetSum);
        return rootSum;
    }

    private static int countPathsWithSumFromNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null) return 0;

        currentSum += root.getData();
        int totalPaths = 0;
        if (currentSum == targetSum) totalPaths++;

        totalPaths += countPathsWithSumFromNode(root.getLeft(), targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(root.getRight(), targetSum, currentSum);
        return totalPaths;
    }

}
