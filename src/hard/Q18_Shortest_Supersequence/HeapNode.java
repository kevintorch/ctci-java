package hard.Q18_Shortest_Supersequence;

public class HeapNode implements Comparable<HeapNode> {
    public int location;
    public int id;

    public HeapNode(int location, int id) {
        this.location = location;
        this.id = id;
    }

    @Override
    public int compareTo(HeapNode o) {
        return location - o.location;
    }
}
