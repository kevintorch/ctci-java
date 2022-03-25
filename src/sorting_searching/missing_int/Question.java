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
import java.io.IOException;
import java.util.Scanner;

public class Question {
    static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    static byte[] bitField = new byte[(int) (numberOfInts / Byte.SIZE)];
    static String filename = "";

    public static void main(String[] args) throws IOException {
//        var ref = new Object() {
//            PrintWriter writer = null;
//        };
//        try {
//            ref.writer = new PrintWriter(new FileWriter("output.txt"));
//            RandomGenerator.getDefault().ints(1L << 32, 0, Integer.MAX_VALUE).forEach(i -> {
//                ref.writer.println(i);
//            });
//        } finally {
//            if (ref.writer != null) ref.writer.close();
//        }

    }

    static void writeFile() throws Exception {

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
}
