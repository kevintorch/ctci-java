package moderate.intersection;

// Given two straight line segments (represented as a start point and an end point),
// compute the point of intersection, if any.

//TODO: Understand this
public class Question {
    public static void main(String[] args) {
        Point zero = Point.ZERO;
        Point secondPoint = new Point(5, 5);
        Line line = new Line(Point.ZERO, secondPoint);
        System.out.println("Length: " + line.length());
    }

    public static Point intersection(Point start1, Point end1, Point start2, Point end2) {
        /* Compute lines (including slope and y-intercept). */
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        /* If the lines are parallel, then their extended lines must have same y-intercept.
         * If so, check that the start or end of one point is on the other line. */
        if (line1.slope == line2.slope) {
            if (line1.yintercept != line2.yintercept) {
                return null;
            }

            /* Check if the start or end of one line is in the other. If so, return that point*/
            if (isBetween(start1, start2, end1)) return start2;
            else if (isBetween(start1, end2, end1)) return end2;
            else if (isBetween(start2, start1, end2)) return start1;
            else if (isBetween(start2, end1, end2)) return end1;
            else return null;
        }

        /* Compute the intersection of the infinite lines, and then check if this falls within the
         * boundary of the line segments. Note that at most one line is vertical. */

        /* Get intersection's x coordinate. If one is vertical, always use its x coordinate.
         * Otherwise, compute the intersection's x coordinate based on setting each line's y = mx + b equation
         * equal and solving for x. */
        double x;
        if (line1.isVertical() || line2.isVertical()) { /* If a line is vertical, use its x coordinate. */
            x = line1.isVertical() ? line1.start.x : line2.start.x;
        } else { /* Set y = mx + b equations equal and solve for x */
            x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        }

        /* Get insection's y coordinate using a non-vertical line. Note that if line1 is vertical
         * then line 2 is not vertical (else it would have been caught earlier). */
        double y = line1.isVertical() ? line2.getYFromX(x) : line1.getYFromX(x);

        /* We now have the intersection of the infinite lines. Check if it's within the boundaries
         * of each line segment. */
        Point intersection = new Point(x, y);
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }

        return null;
    }

    public static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    /* Checks if middle is between start and end. */
    public static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private static void swap(Point p1, Point p2) {
        Point temp = p2.clone();
        p2.setLocation(p1.x, p1.y);
        p1.setLocation(temp.x, temp.y);
    }
}
