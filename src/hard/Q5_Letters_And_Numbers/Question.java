package hard.Q5_Letters_And_Numbers;

// Given an array filled with letters and numbers,
// find the longest sub-array with an equal number of letters and numbers.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.function.IntUnaryOperator;

public class Question {
    public static void main(String[] args) {

        Random random = new Random();

        Character[] smallLetters, capLetters, numbers;
        smallLetters = capLetters = new Character[26];
        numbers = new Character[10];

        fill(smallLetters, operand -> operand + 0x61);
        fill(capLetters, operand -> operand + 0x41);
        fill(numbers, operand -> operand + 0x30);

        ArrayList<Character> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, smallLetters);
        Collections.addAll(arrayList, capLetters);
        Collections.addAll(arrayList, numbers);
        Collections.shuffle(arrayList);
        Collections.shuffle(arrayList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(arrayList.get(random.nextInt(arrayList.size())));
        }
        System.out.println("sb: " + sb);
        char[] longestSubArray = findLongestSubArray(sb.toString().toCharArray());
        char[] longestSubArray2 = QuestionA.findLongestSubarray(sb.toString().toCharArray());
        System.out.println("Longest: " + Arrays.toString(longestSubArray));
        System.out.println("Longest2: " + Arrays.toString(longestSubArray2));

    }


    public static char[] findLongestSubArray(char[] a) {
        for (int len = a.length; len > 1; len--) {
            for (int i = 0; i <= a.length - len; i++) {
                printArray(a, i, i + len - 1);
                if (hasEqualLettersNumbers(a, i, i + len - 1)) {
                    return extractSubArray(a, i, i + len - 1);
                }
            }
        }
        return null;
    }

    private static void printArray(char[] a, int start, int end) {
        StringBuilder sb = new StringBuilder(a.length);
        for (int i = 0; i < a.length; i++) {
            if (i >= start && i <= end) {
                sb.append(a[i]);
            } else {
                sb.append('-');
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static boolean hasEqualLettersNumbers(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            char ch = array[i];
            if (Character.isDigit(ch)) {
                counter++;
            } else if (Character.isLetter(ch)) {
                counter--;
            }
        }
        return counter == 0;
    }

    private static char[] extractSubArray(char[] a, int start, int end) {
        int newLength = end - start + 1;
        if (newLength < 1) return null;
        newLength = Math.min(newLength, a.length - start);
        char[] subArray = new char[newLength];
        for (int i = 0; i < newLength; i++) {
            subArray[i] = a[start + i];
        }
        return subArray;
    }

    private static void fill(Character[] a, IntUnaryOperator operator) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) operator.applyAsInt(i);
        }
    }
}
