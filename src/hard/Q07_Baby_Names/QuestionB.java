package hard.Q07_Baby_Names;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QuestionB {

    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<>();

        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms =
                {{"John", "Jonathan"},
                        {"Jonathan", "Johnny"},
                        {"Chris", "Kris"},
                        {"Brian", "Bryan"}};

        HashMap<String, Integer> rootNames = trulyMostPopular(names, synonyms);
        for (Map.Entry<String, Integer> entry : rootNames.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + ": " + frequency);
        }
    }

    public static HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
        Graph graph = constructGraph(names);
        connectEdges(graph, synonyms);
        return getTrueFrequencies(graph);
    }

    private static HashMap<String, Integer> getTrueFrequencies(Graph graph) {
        HashMap<String, Integer> names = new HashMap<>();
        for (GraphNode node : graph.getNodes()) {
            if (!node.isVisited())
                names.put(node.getName(), getComponentFrequency(node));
        }
        return names;
    }

    private static int getComponentFrequency(GraphNode node) {
        // This is Depth-First.
//        if (node.isVisited()) {
//            return 0;
//        }
//        node.setVisited(true);
//        int sum = node.getFrequency();
//        for (GraphNode child : node.getNeighbors()) {
//            sum += getComponentFrequency(child);
//        }
//        return sum;
        // This is Breath-First.
        int count = 0;
        Queue<GraphNode> table = new LinkedList<>();
        table.add(node);
        while (!table.isEmpty()) {
            GraphNode poll = table.poll();
            if (!poll.isVisited()) {
                count += poll.getFrequency();
                poll.setVisited(true);
                table.addAll(poll.getNeighbors());
            }
        }
        return count;
    }

    private static void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] pair : synonyms) {
            String first = pair[0];
            String second = pair[1];
            graph.addEdge(first, second);
        }
    }

    private static Graph constructGraph(HashMap<String, Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            graph.createNode(entry.getKey(), entry.getValue());
        }
        return graph;
    }

}
