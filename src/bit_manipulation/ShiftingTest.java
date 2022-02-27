package bit_manipulation;

public class ShiftingTest {
    public static void main(String[] args) {
        int x = -93242;
        int count = 40;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE >>> 1);
        System.out.println("1 >>> 1: " + (Integer.MIN_VALUE >>> 1));
        System.out.println("1 >>> 2: " + (2 >>> 2));
        System.out.printf("Shift Arithmetic %d, %d times: %s\n", x, count, repeatedArithmeticRightShift(x, count));
        System.out.printf("Shift Logical %d, %d times: %s\n", x, count, repeatedLogicalRightShift(x, count));
    }

    public static int repeatedArithmeticRightShift(int x, int count) {
        print(x);
        while (count-- != 0) {
            x >>= 1;
            print(x);
        }
        print(x);
        return x;
    }

    private static void print(int n) {
        System.out.println(n);
    }

    public static int repeatedLogicalRightShift(int x, int count) {
        print(x);
        while (count-- != 0) {
            x >>>= 1;
            print(x);
        }
        print(x);
        return x;
    }
}
