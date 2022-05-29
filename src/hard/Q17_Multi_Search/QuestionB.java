package hard.Q17_Multi_Search;

import others.HashMapList;

import java.util.ArrayList;

public class QuestionB {

    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations);
    }

    public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        Trie trie = createTrieFromString(big);

        for (String small : smalls) {
            ArrayList<Integer> locations = trie.search(small);
            subtractValue(locations, small.length());
            lookup.put(small, locations);
        }
        return lookup;
    }

    public static void subtractValue(ArrayList<Integer> locations, int delta) {
        if (locations == null) return;
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }
    }

    private static Trie createTrieFromString(String big) {
        Trie trie = new Trie();
        for (int i = 0; i < big.length(); i++) {
            String suffix = big.substring(i);
            trie.insert(suffix, i);
        }
        return trie;
    }
}
