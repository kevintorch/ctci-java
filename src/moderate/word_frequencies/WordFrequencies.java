package moderate.word_frequencies;

// Design a method to find the frequency of occurrences of any given word in a book.
// What if we were running this algorithm multiple times?

import java.util.HashMap;

public class WordFrequencies {
    public static void main(String[] args) {

    }

    public static void setupDictionary(String[] words) {
        if (words == null) return;
        HashMap<String, Integer> wordFreqTable = new HashMap<>();
        for (String w : words) {
            if (w != null && !w.trim().isEmpty()) {
                String s = w.toLowerCase();
                if (!wordFreqTable.containsKey(s)) {
                    wordFreqTable.put(s, 0);
                }
                wordFreqTable.put(s, wordFreqTable.get(s) + 1);
            }
        }
    }

    public static int frequencyOfWord(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) return 0;
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }

}
