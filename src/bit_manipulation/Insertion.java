package bit_manipulation;

// You are given two 32-bit numbers, N and M, and two bit positions, i and j.
// Write a method to insert M into N such that M starts at bit j and ends at bit i.
// You can assume that the bits j through i have enough space to fit all of M.
// That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
// You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
//
// EXAMPLE
// Input: N 10000000000, M 10011, i 2, j 6 Output:N = 10001001100

public class Insertion {

    public static void main(String[] args) {
        int N = 0b10000000000;
        int M = 0b10011;
        print("Result: ", insert(M, N, 2, 6));
    }

    private static void print(String key, int b) {
        System.out.printf("%s = %s%n", key, Integer.toBinaryString(b));
    }

    public static int insert(int m, int n, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << j + 1;

        int right = (1 << i) - 1;

        int mask = left | right;

        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    public static int insertV2(int m, int n, int i, int j) {
        int mask = (~0 << j + 1) | ((1 << i) - 1);
        return (n & mask) | (m << i);
    }
}
