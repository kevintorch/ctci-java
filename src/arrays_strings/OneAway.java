package arrays_strings;

// There are three types of edits that can be performed on strings:
// insert a character, remove a character, or replace a character.
// Given two strings, write a function to check if they are one edit (or zero edits) away.

// EXAMPLE
// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bake -> false

public class OneAway {
    public static void main(String[] args) {
        System.out.println("pale, ple: " + oneOrZeroEditsAway("pale", "ple"));
        System.out.println("pales, pale: " + oneOrZeroEditsAway("pales", "pale"));
        System.out.println("pale, bale: " + oneOrZeroEditsAway("pale", "bale"));
        System.out.println("pale, bake: " + oneOrZeroEditsAway("pale", "bake"));
    }

    public static boolean oneOrZeroEditsAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (Math.abs(first.length() - second.length()) == 1) {
            if (first.length() > second.length()) {
                return oneEditInsert(first, second);
            } else {
                return oneEditInsert(second, first);
            }
        }
        return false;
    }

    private static boolean oneEditInsert(String s1, String s2) {
        int editsAway = 0;
        for (int i = 0; i < s1.length(); i++) {
            int index = i - editsAway;
            if (index >= s2.length() || s1.charAt(i) != s2.charAt(i - editsAway)) editsAway++;
            if (editsAway > 1) return false;
        }
        return true;
    }

    private static boolean oneEditReplace(String str1, String str2) {
        int editsAway = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) editsAway++;
        }
        return editsAway <= 1;
    }

    private static boolean oneEditAway2(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        String shortString = str1.length() < str2.length() ? str1 : str2;
        String longString = str1.length() > str2.length() ? str1 : str2;

        int sIndex = 0;
        int lIndex = 0;
        boolean foundDifference = false;
        while (sIndex < shortString.length() && lIndex < longString.length()) {
            if (shortString.charAt(sIndex) != longString.charAt(lIndex)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (shortString.length() == longString.length()) {
                    sIndex++;
                }
            } else {
                sIndex++;
            }
            lIndex++;
        }

        return true;
    }
}
