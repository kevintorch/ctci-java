package hard.Q12_BiNode;

public class QuestionB {
    public static void main(String[] args) {

    }

    public static BiNode convert(BiNode root) {
        if (root == null) {
            return null;
        }

        BiNode part1 = convert(root.node1);
        BiNode part2 = convert(root.node2);

        if (part1 != null) {
            concat(getTail(part1), root);
        }

        if (part2 != null) {
            concat(root, part2);
        }

        return part1 == null ? root : part1;
    }

    public static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

    public static BiNode getTail(BiNode node) {
        if (node == null) {
            return null;
        }

        while (node.node2 != null) {
            node = node.node2;
        }
        return node;
    }
}
