package arrays_strings;

// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

import java.util.HashSet;
import java.util.Set;

// EXAMPLE
// Input: Tact Coa
// Output: True (permutations: "taco cat", "atco cta", etc.)
public class PalindromePermutation {
    public static void main(String[] args) {
        String sampleString = "Tact Coa";
        boolean isPalindromePermutation = isPalindromePermutationUsingBV(sampleString);
        System.out.println("is \"Tact Coa\" PalindromePermutation: " + isPalindromePermutation);
    }

    public static boolean isPalindromePermutation(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : str.toCharArray()) {
            int index = getCharIndex(ch);
            if (index == -1) continue;
            if (!charSet.contains(ch)) {
                charSet.add(ch);
            } else {
                charSet.remove(ch);
            }
        }

        return charSet.size() <= 1;
    }

    // With Bit Vector.
    public static boolean isPalindromePermutationUsingBV(String str) {
        int bitVector = createBitVector(str);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int createBitVector(String str) {
        int bitVector = 0;
        for (char ch : str.toCharArray()) {
            int charNumber = getCharNumber(ch);
            bitVector = toggleBitVector(bitVector, charNumber);
        }
        return bitVector;
    }

    private static int toggleBitVector(int checker, int i) {
        if (i == -1) return checker;

        int charIndex = 1 << i;
//        Old Way
//        if ((checker & charIndex) != 0) {
//            checker &= ~charIndex;
//        } else {
//            checker |= charIndex;
//        }
        // New Way
        checker ^= charIndex;
        return checker;
    }

    private static int getCharNumber(char character) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(character);
        if (a <= val && val <= z) return val - a;
        return -1;
    }

    private static int getCharIndex(char character) {
        character = Character.toLowerCase(character);
        return character >= 'a' && character <= 'z' ? character : -1;
    }
}
