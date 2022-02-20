package trees_graphs.build_order;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

    private final String name;
    private final ArrayList<Project> neighbours = new ArrayList<>();
    private final HashMap<String, Project> map = new HashMap<>();
    private int dependencies = 0;
    private State state = State.BLANK;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbour(Project neighbour) {
        if (!map.containsKey(neighbour.name)) {
            map.put(neighbour.name, neighbour);
            neighbours.add(neighbour);
            neighbour.incrementDependencies();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public int getNumberDependencies() {
        return dependencies;
    }

    public ArrayList<Project> getChildren() {
        return neighbours;
    }

    public enum State {COMPLETE, PARTIAL, BLANK}
}
