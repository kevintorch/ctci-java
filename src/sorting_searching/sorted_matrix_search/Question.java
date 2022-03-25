package sorting_searching.sorted_matrix_search;

// Given an M x N matrix in which each row and each column is sorted in ascending order,
// write a method to find an element.

import others.AssortedMethods;

public class Question {
    public static void main(String[] args) {
        int[][] matrix = {
                {15, 30, 50, 70, 73},
                {35, 40, 100, 102, 120},
                {36, 42, 105, 110, 125},
                {46, 51, 106, 111, 130},
                {48, 55, 109, 140, 150}
        };

        AssortedMethods.printMatrix(matrix);
        int findElement = 102;
        Coordinate coordinate = findElementBS(matrix, findElement);
        if (coordinate != null)
            System.out.println(findElement + ": (" + coordinate.row + ", " + coordinate.column + ")");

    }

    static Coordinate findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        Coordinate coordinate = null;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                coordinate = new Coordinate(row, col);
                break;
            } else if (matrix[row][col] < elem) {
                row++;
            } else {
                col--;
            }
        }
        return coordinate;
    }

    static Coordinate findElementBinarySearch(int[][] matrix, Coordinate origin, Coordinate dest, int elem) {
        if (!origin.inBounds(matrix) || !dest.inBounds(matrix)) return null;

        if (matrix[origin.row][origin.column] == elem) {
            return origin;
        } else if (!origin.isBefore(dest)) {
            return null;
        }

        Coordinate start = origin.clone();
        int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
        Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
        Coordinate p = new Coordinate(0, 0);

        while (start.isBefore(end)) {
            p.setToAverage(start, end);
            System.out.println(p);
            if (elem > matrix[p.row][p.column]) {
                start.row = p.row + 1;
                start.column = p.column + 1;
            } else {
                end.row = p.row - 1;
                end.column = p.column - 1;
            }
        }
        return partitionAndSearch(matrix, origin, dest, start, elem);
    }

    static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x) {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

        Coordinate lowerLeft = findElementBinarySearch(matrix, lowerLeftOrigin, lowerLeftDest, x);
        if (lowerLeft == null) {
            return findElementBinarySearch(matrix, upperRightOrigin, upperRightDest, x);
        }
        return lowerLeft;
    }

    static Coordinate findElementBS(int[][] matrix, int elem) {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        return findElementBinarySearch(matrix, origin, dest, elem);
    }


}
