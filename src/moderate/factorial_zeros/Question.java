package moderate.factorial_zeros;

//TODO: Understand this
public class Question {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Factorial: " + factorial(n));
        System.out.println("FactorialZeros: " + factorialZeros(n));
        System.out.println("Facto: " + factorialZeros2(n));
    }

    public static int factorialZeros(int n) {
        int fact = factorial(n);
        int count = 0;
        while (fact % 10 == 0) {
            count++;
            fact /= 10;
        }
        return count;
    }

    private static int factorialZeros2(int n) {
        if (n < 0) {
            return -1;
        }
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }

    private static int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
