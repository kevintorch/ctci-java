package hard.Q7_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphNode {
    private final ArrayList<GraphNode> neighbors;
    private final HashMap<String, GraphNode> map;
    private final String name;
    private final int frequency;
    private boolean visited = false;

    public GraphNode(String nm, int freq) {
        name = nm;
        frequency = freq;
        neighbors = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean addNeighbor(GraphNode node) {
        if (map.containsKey(node.name)) return false;
        neighbors.add(node);
        map.put(node.name, node);
        return true;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
