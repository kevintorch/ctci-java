package moderate.best_line;

import others.HashMapList;

import java.util.ArrayList;
import java.util.Set;

public class Question {
    public static void main(String[] args) {
        Point[] points = createPoints();
        Line line = findBestLine(points);
        line.Print();
        System.out.println(validate(line, points));
    }

    public static Line findBestLine(Point[] points) {
        HashMapList<Double, Line> linesBySlope = getListOfLines(points);
        return getBestLine(linesBySlope);
    }

    public static HashMapList<Double, Line> getListOfLines(Point[] points) {
        HashMapList<Double, Line> linesBySlope = new HashMapList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                double key = Line.floorToNearestEpsilon(line.slope);
                linesBySlope.put(key, line);
            }
        }
        return linesBySlope;
    }

    public static Line getBestLine(HashMapList<Double, Line> linesBySlope) {
        Line bestLine = null;
        int bestCount = 0;

        Set<Double> slopes = linesBySlope.keySet();

        for (double slope : slopes) {
            for (Line line : linesBySlope.get(slope)) {
                int count = countEquivalentLines(linesBySlope, line);

                if (count > bestCount) {
                    bestCount = count;
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }

    private static int countEquivalentLines(HashMapList<Double, Line> linesBySlope, Line line) {
        double key = Line.floorToNearestEpsilon(line.slope);
        int count = countEquivalentLines(linesBySlope.get(key), line);
        count += countEquivalentLines(linesBySlope.get(key - Line.epsilon), line);
        count += countEquivalentLines(linesBySlope.get(key + Line.epsilon), line);
        return count;
    }

    private static int countEquivalentLines(ArrayList<Line> lines, Line line) {
        if (lines == null) return 0;

        int count = 0;
        for (Line parallelLine : lines) {
            if (parallelLine.isEquivalent(line)) {
                count++;
            }
        }

        return count;


    }

    public static Point[] createPoints() {
        int n_points = 100;
        System.out.println("Points on Graph\n***************");
        Point[] points = new Point[n_points - 1];
        for (int i = 0; i < n_points / 2; i++) {
            Point p = new Point(i, 2.3 * ((double) i) + 20.0);
            points[i] = p;
            System.out.println(p);
        }
        for (int i = 0; i < n_points / 2 - 1; i++) {
            Point p = new Point(i, 3.0 * ((double) i) + 1.0);
            points[n_points / 2 + i] = p;
            System.out.println(p);
        }
        System.out.println("****************\n");
        return points;
    }

    public static int validate(Line line, Point[] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line other = new Line(points[i], points[j]);
                if (line.isEquivalent(other)) {
                    count++;
                }
            }
        }
        return count;
    }
}
