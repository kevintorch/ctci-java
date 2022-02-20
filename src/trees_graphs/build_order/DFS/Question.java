package trees_graphs.build_order.DFS;

import trees_graphs.build_order.Graph;
import trees_graphs.build_order.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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

    private static Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) return null;
            }
        }
        return stack;
    }

    private static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) return false;

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            for (Project p : project.getChildren()) {
                if (!doDFS(p, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        final Stack<Project> buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) return null;
        return convertToString(buildOrder);
    }

    private static String[] convertToString(Stack<Project> buildOrder) {
        String[] b = new String[buildOrder.size()];
        for (int i = 0; i < buildOrder.size(); i++) {
            b[i] = buildOrder.pop().getName();
        }
        return b;
    }

    public static Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
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
