package hard.Q19_Missing_Two;

import java.util.Arrays;

public class QuestionB {
    public static void main(String[] args) {
        int[] series = {4, 8, 9, 10, 1, 2, 5, 7};
        int[] missingTwo = missingTwo(series);
        System.out.println("Missing: " + Arrays.toString(missingTwo));
    }

    public static int[] missingTwo(int[] array) {
        int maxValue = array.length + 2;
        int sumSquared = maxValue * (maxValue + 1) * (2 * maxValue + 1) / 6;
        int sum = maxValue * (maxValue + 1) / 2;
        for (int i = 0; i < array.length; i++) {
            sumSquared -= array[i] * array[i];
            sum -= array[i];
        }
        return solveEquation(sum, sumSquared);
    }

    private static int[] solveEquation(double sum, double sumSquared) {

        double a = 2;
        double b = -2 * sum;
        double c = sum * sum - sumSquared;

        double part1 = -1 * b;
        double part2 = Math.sqrt(b * b - 4 * a * c);
        double part3 = 2 * a;

        int x = (int) ((part1 + part2) / part3);
        int y = (int) (sum - x);

        return new int[]{x, y};
    }
}
