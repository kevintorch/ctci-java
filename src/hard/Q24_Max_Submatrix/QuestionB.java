package hard.Q24_Max_Submatrix;

public class QuestionB {
    public static void main(String[] args) {
        int[][] matrix = {{-3, 7, 8, 0}, {0, -1, 10, 0}, {-3, 11, 2, -2}, {0, 6, 0, 1}, {1, -2, 0, 0}};
        SubMatrix subMatrix = getMaxMatrix(matrix);
        System.out.println(subMatrix);
    }


    public static SubMatrix getMaxMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        SubMatrix best = null;
        int[][] sumThrough = precomputeSums(matrix);
        for (int row1 = 0; row1 < rowCount; row1++) {
            for (int row2 = row1; row2 < rowCount; row2++) {
                for (int col1 = 0; col1 < columnCount; col1++) {
                    for (int col2 = col1; col2 < columnCount; col2++) {
                        int sum = sum(sumThrough, row1, col1, row2, col2);
                        if (best == null || best.getSum() < sum) {
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }
        return best;
    }

    private static int sum(int[][] sumThrough, int row1, int col1, int row2, int col2) {
        int topAndLeft = row1 > 0 && col1 > 0 ? sumThrough[row1 - 1][col1 - 1] : 0;
        int left = col1 > 0 ? sumThrough[row2][col1 - 1] : 0;
        int top = row1 > 0 ? sumThrough[row1 - 1][col2] : 0;
        int full = sumThrough[row2][col2];
        return full - left - top + topAndLeft;
    }

    private static int[][] precomputeSums(int[][] matrix) {
        int[][] sumThrough = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                int left = column > 0 ? sumThrough[row][column - 1] : 0;
                int top = row > 0 ? sumThrough[row - 1][column] : 0;
                int overlap = row > 0 && column > 0 ? sumThrough[row - 1][column - 1] : 0;
                sumThrough[row][column] = left + top - overlap + matrix[row][column];
            }
        }
        return sumThrough;
    }

}
