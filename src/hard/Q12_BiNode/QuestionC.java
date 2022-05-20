package hard.Q12_BiNode;

public class QuestionC {
    public static void main(String[] args) {
        BiNode root = createTree();
        printAsTree(root, "");
        BiNode r = convert(root);
        printLinkedListTree(r);
    }

    public static BiNode convert(BiNode root) {
        if (root == null) {return null;}
        BiNode r = convertToCircular(root);
        deConcat(r.node1, r);
        return r;
    }

    public static void deConcat(BiNode x, BiNode y) {
        if (x != null) {
            x.node2 = null;
        }
        if (y != null) {
            y.node1 = null;
        }
    }

    public static BiNode convertToCircular(BiNode root) {
        if (root == null) {return null;}

        BiNode part1 = convertToCircular(root.node1);
        BiNode part3 = convertToCircular(root.node2);

        if (part1 == null && part3 == null) {
            concat(root, root);
            return root;
        }

        BiNode tail3 = part3 == null ? null : part3.node1;

        if (part1 == null) {
            concat(part3.node1, root);
        } else {
            concat(part1.node1, root);
        }

        if (part3 == null) {
            concat(root, part1);
        } else {
            concat(root, part3);
        }

        if (part1 != null && part3 != null) {
            concat(tail3, part1);
        }

        return part1 == null ? root : part1;
    }

    public static void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

    public static BiNode createTree() {
        BiNode[] nodes = new BiNode[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BiNode(i);
        }
        nodes[4].node1 = nodes[2];
        nodes[4].node2 = nodes[5];
        nodes[2].node1 = nodes[1];
        nodes[2].node2 = nodes[3];
        nodes[5].node2 = nodes[6];
        nodes[1].node1 = nodes[0];
        return nodes[4];
    }

    public static void printAsTree(BiNode root, String spaces) {
        if (root == null) {
            System.out.println(spaces + "- null");
            return;
        }
        System.out.println(spaces + "- " + root.data);
        printAsTree(root.node1, spaces + "   ");
        printAsTree(root.node2, spaces + "   ");
    }

    public static void printLinkedListTree(BiNode root) {
        for (BiNode node = root; node != null; node = node.node2) {
            if (node.node2 != null && node.node2.node1 != node) {
                System.out.print("inconsistent node: " + node);
            }
            System.out.print(node.data + "->");
        }
        System.out.println();
    }
}
