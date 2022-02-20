package trees_graphs.route_between_nodes;

import java.util.Arrays;

public class Graph {
    public static int MAX_VERTICES = 6;
    public Node[] nodes;
    public int count;

    public Graph() {
        nodes = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node node) {
        if (count < nodes.length) {
            nodes[count] = node;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public static class Node {
        public final Object data;
        public State state;
        public Node[] nodes;
        private int adjacentCount;

        public Node(Object data, int adjacentLength) {
            this.data = data;
            adjacentCount = 0;
            nodes = new Node[adjacentLength];
        }

        public void addNeighbour(Node n) {
            if (adjacentCount < nodes.length) {
                nodes[adjacentCount] = n;
                adjacentCount++;
            } else {
                System.out.print("No more neighbour can be added");
            }
        }

        public Object getData() {
            return data;
        }

        public Node[] getNeighbours() {
            return nodes;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", adjacentCount=" + adjacentCount +
                    ", state=" + state +
                    ", nodes=" + Arrays.toString(nodes) +
                    '}';
        }

        public enum State {Unvisited, Visited, Visiting}
    }
}
