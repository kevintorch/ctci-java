package trees_graphs.check_subtree;

import trees_graphs.TreeNode;

public class QuestionA {
    public static void main(String[] args) {

    }

    public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;

    }

    private static void getOrderString(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append("X");
            return;
        }
        stringBuilder.append(node.getData());
        getOrderString(node.getLeft(), stringBuilder);
        getOrderString(node.getRight(), stringBuilder);
    }
}
