package moderate.number_max;

// Write a method that finds the maximum of two numbers. You should not use if-else or any other comparison operator.

public class Question {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = 1;

        int max = getMax(a, b);
        print("Max is: " + max);
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    private static int signBit(int n) {
        int sign = flip((n >> 31) & 1);
        print("sign of " + n + ": " + sign);
        return sign;
    }

    private static int flip(int n) {
        return 1 ^ n;
    }

    private static int getMaxNaive(int a, int b) {
        int k = signBit(a - b);
        int q = flip(k);
        return a * k + b * q;
    }

    private static int getMax(int a, int b) {
        int c = a - b;

        int sa = signBit(a);
        int sb = signBit(b);
        int sc = signBit(c);

        int use_sign_of_a = sa ^ sb;
        print("use_sign_of_a: " + use_sign_of_a);

        int use_sign_of_c = flip(use_sign_of_a);
        print("use_sign_of_c: " + use_sign_of_c);

        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k);

        return a * k + b * q;
    }

}
