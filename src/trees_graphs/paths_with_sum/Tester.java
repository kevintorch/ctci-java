package trees_graphs.paths_with_sum;

import trees_graphs.TreeNode;

public class Tester {
    public static void main(String[] args) {
        boolean isWorking = true;
        while (isWorking) {
            int min = -20;
            int max = 20;
            int size = 20;
            TreeNode root = randomBST(size, min, max);

            for (int targetSum = Math.min(-1, min * size - 10); targetSum <= Math.max(100, max * size + 10); targetSum++) {
                int answerA = QuestionA.countPathsWithSum(root, targetSum);
                int answerB = QuestionB.countPathsWithSum(root, targetSum);
                if (answerA > 0 || answerB > 0) {
                    System.out.println(targetSum + ": " + answerA + ", " + answerB + " | " + (answerA == answerB));
                }
                if (answerA != answerB) {
                    isWorking = false;
                    break;
                }
            }
        }
    }

    public static TreeNode randomBST(int N, int min, int max) {
        int d = randomIntInRange(min, max);
        TreeNode root = new TreeNode(d);
        for (int i = 1; i < N; i++) {
            root.insertInOrder(randomIntInRange(min, max));
        }
        return root;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }


}
