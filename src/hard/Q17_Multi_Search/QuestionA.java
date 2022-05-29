package hard.Q17_Multi_Search;

import others.HashMapList;

import java.util.ArrayList;

// Given a string b and an array of smaller strings T, design a method to search b for each small string T.
public class QuestionA {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations);
    }


    public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> map = new HashMapList<>();
        for (String small : smalls) {
            ArrayList<Integer> locations = search(big, small);
            map.put(small, locations);
        }
        return map;
    }

    private static ArrayList<Integer> search(String big, String small) {
        ArrayList<Integer> locations = new ArrayList<>();
        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            if (isSubstringAtLocation(big, small, i)) locations.add(i);
        }
        return locations;
    }

    public static boolean isSubstringAtLocation(String big, String small, int offset) {
        for (int i = 0; i < small.length(); i++) {
            if (big.charAt(offset + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
