package recursion_and_dp;

// Write a method to compute all permutations of a string whose characters are not necessarily unique.
// The list of permutations should not have duplicates.

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDup {
    public static void main(String[] args) {
        String s = "aabbccc";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }

    public static ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    private static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character character : s.toCharArray()) {
            if (!map.containsKey(character)) {
                map.put(character, 0);
            }
            map.put(character, map.get(character) + 1);
        }
        return map;
    }

}
