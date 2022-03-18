package sorting_searching.missing_int;

// Given an input file with four billion non-negative integers,
// provide an algorithm to generate an integer that is not contained in the file.
// Assume you have 1 GB of memory available for this task.
//
// FOLLOW UP
// What if you have only 1O MB of memory? Assume that all the values are distinct
// and we now have no more than one billion non-negative integers.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question {
    static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    static byte[] bitField = new byte[(int) (numberOfInts / Byte.SIZE)];
    static String filename = "";

    public static void main(String[] args) {
        System.out.println(numberOfInts);
        System.out.println(numberOfInts / 8);
    }

    static void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            bitField[n / 8] |= 1 << (n % 8);
        }

        for (int i = 0; i < bitField.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitField[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }

    static void findOpenNumber2() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader((filename)));

    }

    int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[rangeSize];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value / rangeSize]++;
        }
        in.close();
        return blocks;
    }

    int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            if ((b & (1 << i)) == 0) {
                return i;
            }
        }
        return -1;
    }

    int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) {
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }
}
