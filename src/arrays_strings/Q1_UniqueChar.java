package arrays_strings;

import java.util.Arrays;


//Is Unique: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

public class Q1_UniqueChar {
    public static void main(String[] args) {


    }


    // Constraints:
    // 1. input string can only contain chars of ASCII 128 Charset.

    // Complexity:
    // O(n), where n is the length of input string. O(1) space complexity.
    // Or (1), because loop will never iterate through more than 128 characters.
    // Or O(c) space and O(min(c, n)) or O(c) time, where c is the size of the character set.
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_array = new boolean[128];
        for (char ch : str.toCharArray()) {
            if (!char_array[ch]) {
                char_array[ch] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // Constraints:
    // 1. Assuming input string only contains lowercase chars a-z.
    //
    // Optimized:
    // Using Bit Vector.
    //
    public static boolean iUniqueCharsOptimized(String str) {
        if (str.length() > 26) return false;
        int checker = 0;
        for (char ch : str.toCharArray()) {
            int charBitPos = 1 << (ch - 'a');
            // if char exists in checker.
            if ((checker & charBitPos) != 0) {
                return false;
            }
            // add char in checker.
            checker |= charBitPos;
        }
        return true;
    }

    // Constraints:
    // if we are not allowed to use the other data structures then we can loop through string
    // character by character and compare them.

    // *Complexity O(n2) (Duplicates?)
    // '*' means there's a problem with the algorithm.
    public static boolean isUniqueCharsWithoutDS(String str) {
        for (char ch : str.toCharArray()) {
            for (char ch2 : str.toCharArray()) {
                if (ch == ch2) return false;
            }
        }
        return true;
    }

    // Complexity O(n log n) for sorting n chars.
    public static boolean isUniqueCharsUsingSort(String str) {
        str = sortSting(str);
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            char nextCh = str.charAt(i + 1);
            if (ch == nextCh) return false;
        }
        return true;
    }

    public static String sortSting(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


}
