package moderate.Q20_T9;

// On old cell phones, users typed on a numeric keypad and
// the phone would provide a list of words that matched these numbers.
// Each digit mapped to a set of O - 4 letters.
// Implement an algorithm to return a list of matching words, given a sequence of digits.
// You are provided a list of valid words (provided in whatever data structure you'd like).
// The mapping is shown in the diagram below:

import others.Trie;

import java.util.*;

public class Question {

    private static final String[] WORDS_DICTIONARY = new String[]{"tree", "used"};
    private final static Trie WORDS_TRIES = new Trie(WORDS_DICTIONARY);

    private static final Map<Integer, List<Character>> NUM_PAD = new HashMap<>() {
        {
            put(0, new ArrayList<>());
            put(1, new ArrayList<>());
            put(2, Arrays.asList('a', 'b', 'c'));
            put(3, Arrays.asList('d', 'e', 'f'));
            put(4, Arrays.asList('g', 'h', 'i'));
            put(5, Arrays.asList('j', 'k', 'l'));
            put(6, Arrays.asList('m', 'n', 'o'));
            put(7, Arrays.asList('p', 'q', 'r', 's'));
            put(8, Arrays.asList('t', 'u', 'v'));
            put(9, Arrays.asList('w', 'x', 'y', 'z'));
        }
    };

    public static void main(String[] args) {
    }

    public static ArrayList<String> matchingWords(int number) {
        return matchingWords(number, WORDS_DICTIONARY);
    }

    // first of all, its incomplete. I don't know what to do next And Second, it's incorrect of course.
    // so see question B.
    private static ArrayList<String> matchingWords(int number, String[] availableWords) {
        if (number <= 0 || availableWords.length == 0) return new ArrayList<>();
        ArrayList<String> matchingWords = wordsEndsWith(NUM_PAD.get(number % 10), availableWords);
        return matchingWords(number / 10, matchingWords.toArray(String[]::new));
    }

    private static ArrayList<String> wordsEndsWith(List<Character> characters, String[] availableWords) {
        ArrayList<String> words = new ArrayList<>();
        for (char ch : characters) {
            for (String word : availableWords) {
                if (word.endsWith(String.valueOf(ch))) {
                    words.add(word);
                }
            }
        }
        return words;
    }

}
