package moderate.Q13_bisect_squares;

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
