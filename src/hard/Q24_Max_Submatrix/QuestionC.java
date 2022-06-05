package hard.Q24_Max_Submatrix;

public class QuestionC {
    public static void main(String[] args) {

        int[][] matrix = {{-3, 7, 8, 0}, {0, -1, 10, 0}, {-3, 11, 2, -2}, {0, 6, 0, 1}, {1, -2, 0, 0}};
        SubMatrix subMatrix = getMaxMatrix(matrix);
        System.out.println(subMatrix);

    }

    public static SubMatrix getMaxMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        SubMatrix best = null;

        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            int[] partialSum = new int[colCount];

            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                /* Add values at row rowEnd. */
                for (int i = 0; i < colCount; i++) {
                    partialSum[i] += matrix[rowEnd][i];
                }

                Range bestRange = maxSubArray(partialSum, colCount);
                if (best == null || best.getSum() < bestRange.sum) {
                    best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
                }
            }
        }
        return best;
    }

    public static Range maxSubArray(int[] array, int N) {
        Range best = null;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += array[i];
            if (best == null || sum > best.sum) {
                best = new Range(start, i, sum);
            }

            /* If running_sum is < 0 no point in trying to continue the
             * series. Reset. */
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return best;
    }
}
