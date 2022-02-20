package trees_graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphBFS {
    public static final int EDGE_DISTANCE = 5;
    private Graph.Node[] nodes;

    public int[] shortestReach(int startId) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startId);
        int[] distances = new int[nodes.length];
        Arrays.fill(distances, -1);
        distances[startId] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Graph.Node neighbour : nodes[node].adjacent) {
                if (distances[neighbour.getId()] == -1) {
                    distances[neighbour.getId()] = distances[node] + EDGE_DISTANCE;
                    queue.add(neighbour.getId());
                }
            }
        }
        return distances;
    }
}
