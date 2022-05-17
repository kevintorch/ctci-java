package hard.Q7_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private final ArrayList<GraphNode> nodes;
    private final HashMap<String, GraphNode> map;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean hasNode(String name) {
        return map.containsKey(name);
    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }

    public GraphNode getNode(String name) {
        return map.get(name);
    }

    public GraphNode createNode(String name, int freq) {
        if (hasNode(name)) return getNode(name);
        GraphNode node = new GraphNode(name, freq);
        map.put(name, node);
        nodes.add(node);
        return node;
    }

    public void addEdge(String startName, String endName) {
        GraphNode start = getNode(startName);
        GraphNode end = getNode(endName);
        if (start != null && end != null) {
            start.addNeighbor(end);
            end.addNeighbor(start);
        }
    }
}
