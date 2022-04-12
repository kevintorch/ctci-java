package moderate.best_line;

public class Point {
    public static final Point ZERO = new Point(0, 0);
    final double x;
    final double y;

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
