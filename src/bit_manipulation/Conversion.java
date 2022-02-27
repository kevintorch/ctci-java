package bit_manipulation;

// Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
//
// EXAMPLE
// Input: 29 (or: 11101), 15 (or: 01111) Output: 2

public class Conversion {
    public static void main(String[] args) {

    }

    public static int flipBitsCount(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i >>>= 1) {
            count += i & 1;
        }
        return count;
    }

    public static int flipBitsCount2(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i &= i - 1) {
            count++;
        }
        return count;
    }
}
