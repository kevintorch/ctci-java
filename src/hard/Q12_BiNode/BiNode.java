package hard.Q12_BiNode;

public class BiNode {
    public BiNode node1, node2;
    public int data;

    public BiNode(int data) {
        this.data = data;
    }

    public void insertInOrder(int value) {
        if (value <= data) {
            if (node1 == null) {
                node1 = new BiNode(value);
            } else {
                node1.insertInOrder(value);
            }
        } else {
            if (node2 == null) {
                node2 = new BiNode(value);
            } else {
                node2.insertInOrder(value);
            }
        }
    }

    public boolean hasRight() {
        return node2 != null;
    }

    public boolean hasLeft() {
        return node1 != null;
    }
}
