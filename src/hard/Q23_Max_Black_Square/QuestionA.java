package hard.Q23_Max_Black_Square;

public class QuestionA {
    public static void main(String[] args) {

    }

    public static SubSquare findSquareWithSize(int[][] matrix, int squareSize) {
        // On an edge of length N, there are (N - sz + 1) squares of length sz.
        int count = matrix.length - squareSize + 1;

        // Iterate through all squares with side length square_size.
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(matrix, row, col, squareSize)) {
                    return new SubSquare(row, col, squareSize);
                }
            }
        }
        return null;
    }

    public static SubSquare findSquare(int[][] matrix) {
        assert (matrix.length > 0);
        for (int row = 0; row < matrix.length; row++) {
            assert (matrix[row].length == matrix.length);
        }

        int N = matrix.length;

        for (int i = N; i >= 1; i--) {
            SubSquare square = findSquareWithSize(matrix, i);
            if (square != null) {
                return square;
            }
        }
        return null;
    }

    private static boolean isSquare(int[][] matrix, int row, int col, int size) {
        // Check top and bottom border.
        for (int j = 0; j < size; j++) {
            if (matrix[row][col + j] == 1) {
                return false;
            }
            if (matrix[row + size - 1][col + j] == 1) {
                return false;
            }
        }

        // Check left and right border.
        for (int i = 1; i < size - 1; i++) {
            if (matrix[row + i][col] == 1) {
                return false;
            }
            if (matrix[row + i][col + size - 1] == 1) {
                return false;
            }
        }
        return true;
    }

}
