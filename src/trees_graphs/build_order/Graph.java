package trees_graphs.build_order;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private final ArrayList<Project> nodes = new ArrayList<>();
    private final HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (name == null) return null;

        if (!map.containsKey(name)) {
            Project project = new Project(name);
            nodes.add(project);
            map.put(name, project);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbour(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}
