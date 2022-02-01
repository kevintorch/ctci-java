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

    public static boolean oneOrZeroEditsAway(String str1, String str2) {
        int editsAway = 0;
        if (str1.length() == str2.length()) {
            return editsAwayForSameLength(str1, str2, editsAway);
        } else if (Math.abs(str1.length() - str2.length()) == 1) {
            if (str1.length() > str2.length()) {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != str2.charAt(i - editsAway)) editsAway++;
                    if (editsAway > 1) return false;
                }
            } else {
                for (int i = 0; i < str2.length(); i++) {
                    if (str2.charAt(i) != str1.charAt(i - editsAway)) editsAway++;
                    if (editsAway > 1) return false;
                }
            }
            return true;
        }

        return false;
    }

    private static boolean editsAwayForSameLength(String str1, String str2, int editsAway) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) editsAway++;
            if (editsAway > 1) return true;
        }
        return false;
    }
}
