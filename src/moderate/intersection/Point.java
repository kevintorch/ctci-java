package moderate.intersection;

public class Point {
    public static final Point ZERO = new Point(0, 0);
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point clone() {
        return new Point(x, y);
    }

    public double minus(Point other) {
        double xDelta = x - other.x;
        double yDelta = y - other.y;
        return Math.hypot(xDelta, yDelta);
    }
}
