package arrays_strings;

import others.AssortedMethods;

public class Q7_Rotate {

    /*
     *   2  4  5  6
     *   2  4  5  6
     *   2  4  5  6
     *   2  4  5  6
     *
     *
     * */

    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }

    public static void rotate(int[][] matrix) {
        if (matrix.length != matrix[0].length) return;
        int matrixLength = matrix.length;
        int levels = matrixLength / 2;

        for (int level = 0; level < levels; level++) {
            int last = matrixLength - level - 1;

            for (int i = level; i < last; i++) {
                int offset = i - level;

                int topLeft = matrix[level][i];

                // bottomLeft to topLeft.
                matrix[level][i] = matrix[last - offset][level];

                // bottomRight to bottomLeft.
                matrix[last - offset][level] = matrix[last][last - offset];

                // topRight to bottomRight.
                matrix[last][last - offset] = matrix[i][last];

                // topLeft to topRight.
                matrix[i][last] = topLeft;
            }


        }

    }
}
