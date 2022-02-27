package bit_manipulation;

// Given a positive integer, print the next smallest and the next largest number
// that have the same number of 1 bits in their binary representation.

public class NextNumber {
    public static void main(String[] args) {
        int f = 0x55;
        binPrint(getPrev(227));
    }

    private static void binPrint(int i) {
        System.out.println(i + ": " + Integer.toBinaryString(i));
    }

    public static int getNextArith(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        final int pos = c0 + c1;
        if (pos == 31 || pos == 0) return -1;

        return n + (1 << c0) + 1 + (1 << c1 - 1) - 1;
    }

    public static int getPrevArith(int n) {
        int c = n;
        int c1 = 0;
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c == 0) return -1;
        int c0 = 0;
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        int pos = c0 + c1;

        return n - (1 << c1) - (1 << c0 - 1) + 1;
    }

    public static int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        final int pos = c0 + c1;
        if (pos == 31 || pos == 0) return -1;


        n |= 1 << pos;
        n &= -(1 << pos);
        n |= (1 << (c1 - 1)) - 1;
        return n;
    }

    public static int getPrev(int n) {
        int c = n;
        int c1 = 0;
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c == 0) return -1;
        int c0 = 0;
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        int pos = c0 + c1;

        n &= -(1 << pos + 1);
        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);

        return n;
    }
}
