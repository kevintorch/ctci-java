package hard.Q23_Max_Black_Square;

public class Question {
    public static void main(String[] args) {
        /*
         * 0 1 1 0
         * 1 0 0 0
         * 1 0 1 0
         * 1 0 0 0
         * */

        int[][] matrix = {{0, 1, 1, 0}, {1, 0, 0, 0}, {1, 0, 1, 0}, {1, 0, 0, 0}};
        SubSquare maxSquare = findMaxSquare(matrix);
        if (maxSquare != null)
            maxSquare.print();
        else System.out.println("Null");
    }

    private static void printMatrix(int[] matrix) {
        if (matrix == null) {
            System.out.println("Null");
            return;
        }
        System.out.print(" [" + matrix[0] + ", " + matrix[1] + "]");
        System.out.print(" [" + matrix[0] + ", " + (matrix[1] + matrix[2] - 1) + "]");
        System.out.print(" [" + (matrix[0] + matrix[2] - 1) + ", " + matrix[1] + "]");
        System.out.print(" [" + (matrix[0] + matrix[2] - 1) + ", " + (matrix[1] + matrix[2] - 1) + "]");
    }

    public static SubSquare findMaxSquare(int[][] matrix) {
        int length = matrix.length;
        if (length < 2) return null;
        for (int k = length; k > 1; k--) {
            for (int row = 0; row <= length - k; row++) {
                for (int column = 0; column <= length - k; column++) {
                    if (isSquareBlack(matrix, row, column, k)) {
                        return new SubSquare(row, column, k);
                    }
                }
            }
            System.out.println();
        }
        return null;
    }

    private static boolean isSquareBlack(int[][] matrix, int row, int column, int size) {
        for (int i = 0; i < size; i++) {
            int topLeft = matrix[row][column + i];
            int topRight = matrix[row + i][column + size - 1];
            int bottomRight = matrix[row + size - 1][size - 1 + column - i];
            int bottomLeft = matrix[row + size - 1 - i][column];
            if (topLeft == 1 || topRight == 1 || bottomRight == 1 || bottomLeft == 1) {
                return false;
            }
        }
        return true;
    }


}
