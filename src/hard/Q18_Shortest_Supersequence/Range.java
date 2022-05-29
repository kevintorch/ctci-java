package hard.Q18_Shortest_Supersequence;

public class Range {
    public int start;
    public int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int size() {
        return end - start + 1;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
