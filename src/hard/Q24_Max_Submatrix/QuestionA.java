package hard.Q24_Max_Submatrix;

public class QuestionA {
    public static void main(String[] args) {

        /*
         *  -3,  7,  8,  0
         *   0, -1, 10,  0
         *  -3, 11,  2, -2
         *   0,  6,  0,  1
         *
         * */
        int[][] matrix = {{-3, 7, 8, 0}, {0, -1, 10, 0}, {-3, 11, 2, -2}, {0, 6, 0, 1}, {1, -2, 0, 0}};
        SubMatrix subMatrix = getMaxMatrix(matrix);
        System.out.println(subMatrix);
    }

    public static SubMatrix getMaxMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        SubMatrix best = null;
        for (int row1 = 0; row1 < rowCount; row1++) {
            for (int row2 = row1; row2 < rowCount; row2++) {
                for (int col1 = 0; col1 < columnCount; col1++) {
                    for (int col2 = col1; col2 < columnCount; col2++) {
                        int sum = sum(matrix, row1, col1, row2, col2);
                        if (best == null || best.getSum() < sum) {
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }
        return best;
    }

    private static int sum(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }
}
