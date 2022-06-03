package hard.Q22_Word_Transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

// TODO:- Understand this.
public class QuestionA {
    public static void main(String[] args) {
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat",
                "trap", "fret", "trip", "trie", "frat", "fril"};
        LinkedList<String> list = transform("tree", "flat", words);

        if (list == null) {
            System.out.println("No path.");
        } else {
            System.out.println(list);
        }
    }

    private static LinkedList<String> transform(String start, String stop, String[] words) {
        HashSet<String> dictionary = setupDictionary(words);
        HashSet<String> visited = new HashSet<>();
        return transform(visited, start, stop, dictionary);
    }

    private static LinkedList<String> transform(HashSet<String> visited, String startWord, String stopWord,
                                                HashSet<String> dictionary) {
        if (startWord.equals(stopWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(startWord);
            return path;
        } else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
            return null;
        }

        visited.add(startWord);
        System.out.println("Visited: " + visited);
        ArrayList<String> words = wordsOneAway(startWord);

        for (String word : words) {
            LinkedList<String> path = transform(visited, word, stopWord, dictionary);
            if (path != null) {
                System.out.println("Path: " + path);
                path.addFirst(startWord);
                return path;
            }
        }

        return null;
    }

    public static ArrayList<String> wordsOneAway(String word) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String w = word.substring(0, i) + c + word.substring(i + 1);
                words.add(w);
            }
        }
        return words;
    }

    public static HashSet<String> setupDictionary(String[] words) {
        HashSet<String> hash = new HashSet<>();
        for (String word : words) {
            hash.add(word.toLowerCase());
        }
        return hash;
    }
}
