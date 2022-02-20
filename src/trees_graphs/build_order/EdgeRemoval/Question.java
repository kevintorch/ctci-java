package trees_graphs.build_order.EdgeRemoval;

// You are given a list of projects and a list of dependencies
// (which is a list of pairs of projects, where the second project is dependent on the first project).
// All of a project's dependencies must be built before the project is.
// Find a build order that will allow the projects to be built.
// If there is no valid build order, return an error.
//
// EXAMPLE
// Input:
// projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c

import trees_graphs.build_order.Graph;
import trees_graphs.build_order.Project;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency");
        } else {
            System.out.println(Arrays.toString(buildOrder));
        }
    }

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        final Project[] buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) return null;
        return convertToString(buildOrder);
    }

    private static String[] convertToString(Project[] buildOrder) {
        String[] b = new String[buildOrder.length];
        for (int i = 0; i < buildOrder.length; i++) {
            b[i] = buildOrder[i].getName();
        }
        return b;
    }

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return buildProjects(graph.getNodes());
    }

    private static Project[] buildProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if (current == null)
                return null;

            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project p : projects) {
            if (p.getNumberDependencies() == 0) {
                order[offset] = p;
                offset++;
            }
        }
        return offset;
    }

    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph g = new Graph();
        for (String p : projects) {
            g.getOrCreateNode(p);
        }

        for (String[] d : dependencies) {
            g.addEdge(d[0], d[1]);
        }

        return g;
    }


}
