package arrays_strings;

// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees. Can you do this in place?

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        Integer[][] vector4x4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Character[][] matrix3x3 = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        printMatrix(vector4x4);
        rotate90(vector4x4, false);
        printMatrix(vector4x4);
        System.out.println();

        printMatrix(matrix3x3);

        System.out.println("Rotating by 90º Two Times");

        rotate90(matrix3x3, true);
        rotate90(matrix3x3, true);

        printMatrix(matrix3x3);

        System.out.println("Rotating by 180º");

        rotate180(matrix3x3);

        printMatrix(matrix3x3);
    }

    private static <T> void printMatrix(T[][] matrix) {
        System.out.println();
        for (T[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private static <T> void rotate90(T[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return;
        int len = matrix.length;
        int levels = len / 2;
        for (int level = 0; level < levels; level++) {
            int last = len - 1 - level;
            for (int i = level; i < last; i++) {
                int offset = i - level;
                T top = matrix[level][i];

                matrix[level][i] = matrix[last - offset][level];

                matrix[last - offset][level] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static <T> void rotate90(T[][] matrix, boolean clockwise) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                T top = matrix[layer][i];

                // if clockwise then Left to Top otherwise Right to Top.
                matrix[layer][i] = clockwise ? matrix[last - offset][layer] : matrix[i][last];

                //if clockwise Bottom to Left.
                if (clockwise) {
                    matrix[last - offset][layer] = matrix[last][last - offset];
                } else {
                    // Bottom to Right
                    matrix[i][last] = matrix[last][last - offset];
                }

                // if clockwise then Right to Bottom otherwise Left to Bottom.
                matrix[last][last - offset] = clockwise ? matrix[i][last] : matrix[last - offset][layer];

                // Top to Right.
                if (clockwise) {
                    matrix[i][last] = top;
                } else {
                    // Top to Left
                    matrix[last - offset][layer] = top;
                }

            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static <T> void rotate180(T[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                T temp = matrix[layer][i];

                // Bottom to Top.
                matrix[layer][i] = matrix[last][last - offset];
                // Top to Bottom.
                matrix[last][last - offset] = temp;


                temp = matrix[last - offset][layer];
                // Right to Left.
                matrix[last - offset][layer] = matrix[i][last];
                // Left to Right.
                matrix[i][last] = temp;

            }
        }
    }

    public static <T> void rotate90(T[][] matrix, boolean clockwise, int times) {
        if (times <= 0 || times % 4 == 0) return;

        times %= 4;

        if (times == 1) {
            rotate90(matrix, clockwise);
        } else if (times == 2) {
            rotate180(matrix);
        } else {
            rotate90(matrix, !clockwise);
        }

    }
}
