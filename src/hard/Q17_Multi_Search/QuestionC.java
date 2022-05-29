package hard.Q17_Multi_Search;

import others.HashMapList;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionC {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations);
    }

    public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        Trie trie = createTrieFromStringArray(smalls, big.length());
        trie.print();
        for (int i = 0; i < big.length(); i++) {
            System.out.println();
            System.out.println(big);
            System.out.println(space(i) + big.substring(i));
            ArrayList<String> stringsAtLoc = findStringsAtLoc(trie.getRoot(), big, i);
            System.out.println(stringsAtLoc);
            for (String s : stringsAtLoc) {
                lookup.put(s, i);
            }
        }
        return lookup;
    }

    private static String space(int size) {
        return String.join("", new Spacer(size));
    }

    private static ArrayList<String> findStringsAtLoc(TrieNode root, String big, int start) {
        ArrayList<String> strings = new ArrayList<>();
        int index = start;
        while (index < big.length()) {
            root = root.getChild(big.charAt(index));

            if (root == null) break;
            if (root.terminates()) {
                strings.add(big.substring(start, index + 1));
            }

            index++;
        }
        return strings;
    }

    private static Trie createTrieFromStringArray(String[] smalls, int size) {
        Trie trie = new Trie();
        for (String s : smalls) {
            if (s.length() <= size)
                trie.insert(s, 0);
        }
        return trie;
    }

    private static class Spacer implements Iterable<String> {
        private final int size;

        public Spacer(int size) {
            this.size = size;
        }

        @Override
        public Iterator<String> iterator() {
            return new SpaceItr();
        }

        class SpaceItr implements Iterator<String> {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public String next() {
                count++;
                return " ";
            }
        }
    }
}
