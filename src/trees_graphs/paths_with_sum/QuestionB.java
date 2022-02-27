package trees_graphs.paths_with_sum;

import trees_graphs.TreeNode;

import java.util.HashMap;

public class QuestionB {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(5));
        root.setRight(new TreeNode(-3));
        root.getRight().setRight(new TreeNode(11));
        root.getLeft().setRight(new TreeNode(1));
        root.getLeft().getRight().setRight(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setRight(new TreeNode(-2));
        root.getLeft().getLeft().setLeft(new TreeNode(3));

        System.out.println(countPathsWithSum(root, 8));
//        System.out.println(countPathsWithSum(root, 4));
    }

    public static int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<>());
    }

    public static int countPathsWithSum(TreeNode root, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (root == null) return 0;

        runningSum += root.getData();

        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1);

        totalPaths += countPathsWithSum(root.getLeft(), targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(root.getRight(), targetSum, runningSum, pathCount);

        incrementHashTable(pathCount, runningSum, -1);
        return totalPaths;
    }

    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        final Integer value = hashTable.getOrDefault(key, 0);
        int newCount = value + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}