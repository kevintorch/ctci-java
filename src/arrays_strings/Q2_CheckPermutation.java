package arrays_strings;


//Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

public class Q2_CheckPermutation {
    public static void main(String[] args) {

    }

    // Complexity: O (n^2)
    // Assumptions:
    // 1. input string will not contain any spaces. or if it does then it should contain equal spaces in other string.

    // *WRONG: doesn't count for duplicate chars.
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            if (str2.indexOf(ch1) < 0) return false;
        }


        return true;
    }


    // Complexity O(n log n)
    public static boolean isPermutationOptimized(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        str1 = Q1_UniqueChar.sortSting(str1);
        str2 = Q1_UniqueChar.sortSting(str2);

        return str1.equals(str2);
    }

    // By Character counting.
    public static boolean isPermutationWithDS(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] str1_array = new int[128]; // Assumption.
        for (char ch : str1.toCharArray()) {
            str1_array[ch]++;
        }

        for (char ch : str2.toCharArray()) {
            str1_array[ch]--;
            if (str1_array[ch] < 0) return false;
        }

        return true;
    }
}
