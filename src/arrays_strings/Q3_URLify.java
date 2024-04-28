package arrays_strings;

// Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end to hold the additional characters,
// and that you are given the "true" length of the string.
// (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)

import java.util.Arrays;

public class Q3_URLify {

    public static void main(String[] args) {
        String sampleString = "Hello I Am Karan      ";
        char[] chars = sampleString.toCharArray();
        replaceSpace(chars, sampleString.trim().length());
        System.out.println("Encoded: " + new String(chars));
    }

    public static void replaceSpace(char[] chars, int trueLength) {

        int spaceCount = 0, index, i;

        for (i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') spaceCount++;
        }

        index = trueLength + spaceCount * 2;
        if (trueLength < chars.length) chars[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index = index - 3;

            } else {
                chars[index - 1] = chars[i];
                index--;
            }
            System.out.println("Array: " + Arrays.toString(chars));
        }

    }
}
