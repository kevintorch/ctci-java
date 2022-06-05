package hard.Q24_Max_Submatrix;

public class Question {
    public static void main(String[] args) {

        /*
         *  -3,  7,  8,  0
         *   0, -1, 10,  0
         *  -3, 11,  2, -2
         *   0,  6,  0,  1
         *
         * */
        int[][] matrix = {{-3, 7, 8, 0}, {0, -1, 10, 0}, {-3, 11, 2, -2}, {0, 6, 0, 1}, {1, -2, 0, 0}};
        SubMatrix subMatrix = largestSumMatrix(matrix);
        System.out.println(subMatrix);
    }


    private static SubMatrix largestSumMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        SubMatrix subMatrix = null;
        for (int row = 0; row < rowCount; row++) {
            for (int row1 = row; row1 < rowCount; row1++) {
                for (int column = 0; column < columnCount; column++) {
                    for (int column1 = column; column1 < columnCount; column1++) {
                        int sum = sum(matrix, row, row1, column, column1);
                        if (subMatrix == null || subMatrix.getSum() < sum) {
                            subMatrix = new SubMatrix(row, column, row1, column1, sum);
                        }
                    }
                }
            }
        }
        return subMatrix;
    }

    private static int sum(int[][] matrix, int r, int r1, int c, int c1) {
        int sum = 0;
        for (int row = r; row <= r1; row++) {
            for (int column = c; column <= c1; column++) {
                sum += matrix[row][column];
            }
        }
        return sum;
    }

}
