package moderate.Q13_bisect_squares;

public class Line {
    public final Point start;
    public final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line From" +
                start.toString() +
                " to " + end.toString();
    }
}
