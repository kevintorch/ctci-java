package trees_graphs.route_between_nodes;

import java.util.LinkedList;

// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

public class Question {

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Graph.Node[] n = g.getNodes();
        Graph.Node start = n[1];
        Graph.Node end = n[5];
        System.out.println(search2(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Graph.Node[] temp = new Graph.Node[6];

        temp[0] = new Graph.Node("a", 3);
        temp[1] = new Graph.Node("b", 0);
        temp[2] = new Graph.Node("c", 0);
        temp[3] = new Graph.Node("d", 1);
        temp[4] = new Graph.Node("e", 1);
        temp[5] = new Graph.Node("f", 0);

        temp[0].addNeighbour(temp[1]);
        temp[0].addNeighbour(temp[2]);
        temp[0].addNeighbour(temp[3]);
        temp[3].addNeighbour(temp[4]);
        temp[4].addNeighbour(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean search(Graph graph, Graph.Node start, Graph.Node end) {
        if (start == end) return true;

        LinkedList<Graph.Node> queue = new LinkedList<>();
        for (Graph.Node u : graph.nodes) {
            u.state = Graph.Node.State.Unvisited;
        }
        if (start != null)
            start.state = Graph.Node.State.Visiting;
        queue.add(start);
        while (!queue.isEmpty()) {
            Graph.Node n = queue.remove();
            System.out.println("Node: " + n);
            if (n != null) {
                for (Graph.Node neighbour : n.nodes) {
                    if (neighbour.state == Graph.Node.State.Unvisited) {
                        System.out.println("Node neighbour: " + neighbour);
                        if (neighbour == end) {
                            return true;
                        } else {
                            neighbour.state = Graph.Node.State.Visiting;
                            queue.add(neighbour);
                        }
                    }
                }
                n.state = Graph.Node.State.Visited;
            }
        }
        return false;
    }

    public static boolean searchRecursively(Graph.Node start, Graph.Node end, LinkedList<Graph.Node> queue) {
        if (start == end) return true;
        if (start != null) {
            for (Graph.Node neighbour : start.nodes) {
                if (neighbour.state == Graph.Node.State.Unvisited) {
                    neighbour.state = Graph.Node.State.Visiting;
                    queue.add(neighbour);
                }
            }
            start.state = Graph.Node.State.Visited;
        }
        if (!queue.isEmpty()) {
            return searchRecursively(queue.remove(), end, queue);
        }
        return false;
    }

    public static boolean search2(Graph graph, Graph.Node start, Graph.Node end) {
        if (start == end) return true;

        LinkedList<Graph.Node> queue = new LinkedList<>();
        for (Graph.Node u : graph.nodes) {
            u.state = Graph.Node.State.Unvisited;
        }
        return searchRecursively(start, end, queue);
    }
}
