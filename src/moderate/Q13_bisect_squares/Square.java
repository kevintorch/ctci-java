package moderate.Q13_bisect_squares;


// TODO:- Review and Understand
public class Square {
    public double left;
    public double top;
    public double bottom;
    public double right;
    public double size;

    public Square(double left, double top, double size) {
        this.left = left;
        this.top = top;
        this.bottom = top + size;
        this.right = left + size;
        this.size = size;
    }

    public Point middle() {
        return new Point((this.left + this.right) / 2.0, (this.top + this.bottom) / 2.0);
    }

    public Point extend(Point mid1, Point mid2, double size) {

        double xdir = mid1.x < mid2.x ? -1 : 1;
        double ydir = mid1.y < mid2.y ? -1 : 1;

        double yIncreased = mid1.y + ydir * size / 2.0;
        double xIncreased = mid1.x + xdir * size / 2.0;

        if (mid1.x == mid2.x) {
            return new Point(mid1.x, yIncreased);
        }

        double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);

        double x1;
        double y1;

        if (Math.abs(slope) == 1) {
            x1 = xIncreased;
            y1 = yIncreased;
        } else if (Math.abs(slope) < 1) {
            x1 = xIncreased;
            y1 = slope * (x1 - mid1.x) + mid1.y;
        } else {
            y1 = yIncreased;
            x1 = (y1 - mid1.y) / slope + mid1.x;
        }
        return new Point(x1, y1);
    }


    public Line cut(Square other) {
        Point p1 = extend(this.middle(), other.middle(), this.size);
        Point p2 = extend(this.middle(), other.middle(), -1 * this.size);
        Point p3 = extend(other.middle(), this.middle(), other.size);
        Point p4 = extend(other.middle(), this.middle(), -1 * other.size);

        Point start = p1;
        Point end = p1;

        Point[] points = {p2, p3, p4};
        for (Point point : points) {
            if (point.x < start.x || (point.x == start.x && point.y < start.y)) {
                start = point;
            } else if (point.x > end.x || (point.x == end.x && point.y > end.y)) {
                end = point;
            }
        }

        return new Line(start, end);
    }
}
