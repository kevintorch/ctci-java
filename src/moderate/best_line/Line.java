package moderate.best_line;

public class Line {
    public static final double epsilon = 0.5;
    public final Point start;
    public final Point end;
    public final double slope;
    public final boolean isSlopeInfinite;
    public final double intercept;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (Math.abs(start.x - end.x) < epsilon) {
            isSlopeInfinite = true;
            slope = Double.POSITIVE_INFINITY;
            intercept = start.x;
        } else {
            slope = (start.y - end.y) / (start.x - end.x);
            intercept = start.y - slope * start.x;
            isSlopeInfinite = false;
        }
    }

    public static double floorToNearestEpsilon(double d) {
        int r = (int) (d / epsilon);
        return ((double) r) * epsilon;
    }

    public boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }

    public boolean isEquivalent(Line line) {
        return isEquivalent(line.slope, this.slope) &&
                isEquivalent(intercept, line.intercept) &&
                isSlopeInfinite == line.isSlopeInfinite;
    }

    @Override
    public String toString() {
        return "Line From" +
                start.toString() +
                " to " + end.toString();
    }

    public void Print() {
        System.out.println("y = " + slope + "x + " + intercept);
    }
}
