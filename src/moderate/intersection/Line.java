package moderate.intersection;

public class Line {
    double slope, yintercept;
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.x == end.x) {
            slope = Double.POSITIVE_INFINITY;
            yintercept = Double.POSITIVE_INFINITY;
        } else {
            slope = (end.y - start.y) / (end.x - start.x);
            yintercept = end.y - slope * end.x;
        }
    }

    public boolean isVertical() {
        return slope == Double.POSITIVE_INFINITY;
    }

    public double getYFromX(double x) {
        if (isVertical()) {
            return Double.POSITIVE_INFINITY;
        }
        return slope * x + yintercept;
    }

    public double length() {
        return end.minus(start);
    }
}
