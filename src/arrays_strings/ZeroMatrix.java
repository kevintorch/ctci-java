package arrays_strings;

// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

public class ZeroMatrix {
    public static void main(String[] args) {

    }

    // First Attempt
    private static void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    rows[row] = true;
                    columns[column] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) nullifyRow(matrix, i);
        }

        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) nullifyColumn(matrix, i);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    private static void zeroMatrix2(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                nullifyRow(matrix, row);
        }

        for (int column = 1; column < matrix[0].length; column++) {
            if (matrix[0][column] == 0) {
                nullifyColumn(matrix, column);
            }
        }

        if (firstRowHasZero)
            nullifyRow(matrix, 0);


        if (firstColumnHasZero)
            nullifyColumn(matrix, 0);
    }
}
