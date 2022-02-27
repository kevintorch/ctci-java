package bit_manipulation;

// Write a program to swap odd and even bits in an integer with as few instructions as possible
// (e.g., bit O and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

public class PairwiseSwap {
    public static void main(String[] args) {

    }

    public static int swapOddEvenBits(int n) {
        return (n & 0xAAAAAAAA >>> 1) | (n & 0x55555555 << 1);
    }
}
