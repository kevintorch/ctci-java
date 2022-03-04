package recursion_and_dp;

// Write a method to compute all permutations of a string of unique characters.

import java.util.ArrayList;

public class PermutationWithoutDup {
    public static void main(String[] args) {
        ArrayList<String> list = getPerms3("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> getPerms3(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms("", str, result);
        return result;
    }

    private static void getPerms(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String end = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c, before + end, result);
        }
    }

    public static ArrayList<String> permutationsOf2(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        for (int i = 0; i < str.length(); i++) {
            String before = str.substring(0, i);
            String end = str.substring(i + 1);
            ArrayList<String> perms = permutationsOf2(before + end);

            for (String perm : perms) {
                permutations.add(str.charAt(i) + perm);
            }
        }
        return permutations;
    }

    public static ArrayList<String> permutationsOf(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> remainderPerms = permutationsOf(remainder);
        for (String perm : remainderPerms) {
            for (int i = 0; i <= perm.length(); i++) {
                String p = insertCharAt(perm, first, i);
                permutations.add(p);
            }
        }

        return permutations;
    }

    public static ArrayList<String> getPerms(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static ArrayList<String> getPerms2(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<>();

        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms2(before + after);

            for (String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }
}
