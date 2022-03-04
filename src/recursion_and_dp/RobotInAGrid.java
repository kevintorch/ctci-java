package recursion_and_dp;

// Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
// The robot can only move in two directions, right and down, but certain cells are "off limits"
// such that the robot cannot step on them.
// Design an algorithm to find a path for the robot from the top left to the bottom right.

import others.AssortedMethods;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {
    public static void main(String[] args) {
        int size = 20;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 60);

        AssortedMethods.printMatrix(maze);

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println(path);
        } else {
            System.out.println("No path found.");
        }
    }

    public static ArrayList<Point> getPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        /* if out of bounds or not available, return. */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        /* if there's a path from the start to here, add my location. */
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public static ArrayList<Point> getPath2(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        /* if out of bounds or not available, return. */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);
        if (failedPoints.contains(p)) return false;
        boolean isAtOrigin = (row == 0) && (col == 0);
        /* if there's a path from the start to my current location, add my location. */
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

    private static class Point {

        public int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(" + row +
                    ", " + column +
                    ')';
        }

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column);
        }

    }
}
