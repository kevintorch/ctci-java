package hard.Q19_Missing_Two;

import java.util.Arrays;

public class QuestionA {
    public static void main(String[] args) {
        int[] series = {4, 6, 8, 9, 10, 1, 2, 5, 3, 7};
        double[] missingTwo = missingTwo(series, 10);
        System.out.println("Missing: " + Arrays.toString(missingTwo));
    }

    public static double[] missingTwo(int[] numbers, int n) {
        if (numbers.length == n) return new double[0];

        double sum = sum(numbers);
        double naturalSum = (double) n * (n + 1) / 2;
        double sumSquared = sumSquared(numbers);
        double naturalSumSquared = naturalSumSquared(n);

        double abSum = naturalSum - sum;
        double abSumSquared = naturalSumSquared - sumSquared;

        double b = (Math.sqrt((2 * abSumSquared) - Math.pow(abSum, 2)) + abSum) / 2;
        double a = abSum - b;

        return new double[]{a, b};

    }

    private static double sumSquared(int[] a) {
        double sum = 0;
        for (int e : a) sum += (e * e);
        return sum;
    }

    private static double naturalSumSquared(int n) {
        double sum = 0;
        for (int i = n; i >= 1; i--) {
            sum += (i * i);
        }
        return sum;
    }

    public static double sum(int[] a) {
        double sum = 0;
        for (int e : a) sum += e;
        return sum;
    }
}
