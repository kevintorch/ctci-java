package recursion_and_dp;

// Write a recursive function to multiply two positive integers without using
// the * operator (or / operator). You can use addition, subtraction, and bit shifting,
// but you should minimize the number of those operations.

public class RecursiveMultiply {
    public static void main(String[] args) {

    }

    public static int multiply(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return multiplyHelper(smaller, bigger);
    }

    public static int multiplyHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int halfProd = multiply(s, bigger);
        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }
}
