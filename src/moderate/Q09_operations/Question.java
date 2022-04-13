package moderate.Q09_operations;

import others.AssortedMethods;

public class Question {
    public static void main(String[] args) {

        int minRange = -100;
        int maxRange = 100;
        int cycles = 100;

        for (int i = 0; i < cycles; i++) {
            int a = AssortedMethods.randomIntInRange(minRange, maxRange);
            int b = AssortedMethods.randomIntInRange(minRange, maxRange);
            System.out.print(a + " / " + b + " = ");
            int ans = divide(a, b);
            if (ans != a / b) {
                System.out.println("ERROR");
            }
            System.out.println(ans);
        }
    }

    public static int subtract(int a, int b) {
        return a + negateOptimized(b);
    }

    public static int multiply(int a, int b) {
        if (a > b) {
            return multiply(b, a);
        }
        int sum = a;
        for (int i = 1; i < abs(b); i++) {
            sum += a;
        }
        if (b < 0) {
            sum = negateOptimized(sum);
        }
        return sum;
    }

    private static int abs(int n) {
        if (n < 0) return negateOptimized(n);
        return n;
    }

    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Error");
        int absA = abs(a);
        int absB = abs(b);

        if (absA < absB) {
            return 0;
        }

        int diff = 0;
        while (subtract(absA, absB) >= 0) {
            absA = subtract(absA, absB);
            diff++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return diff;
        }

        return negateOptimized(diff);
    }


    public static int negate(int n) {
        int neg = 0;
        int newSign = n < 0 ? 1 : -1;
        while (n != 0) {
            neg += newSign;
            n += newSign;
        }
        return neg;
    }

    public static int negateOptimized(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;
        while (a != 0) {
            boolean diffSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && diffSigns) {
                delta = newSign;
            }
            neg += delta;
            a += delta;
            delta += delta;
        }
        return neg;
    }

}
