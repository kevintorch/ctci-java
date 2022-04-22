package moderate.Q20_T9;

import others.AssortedMethods;
import others.Trie;
import others.TrieNode;

import java.util.ArrayList;

public class QuestionB {
    static char[][] t9Letters = new char[][]{
            null,                   // 0
            null,                   // 1
            {'a', 'b', 'c'},        // 2
            {'d', 'e', 'f'},        // 3
            {'g', 'h', 'i'},        // 4
            {'j', 'k', 'l'},        // 5
            {'m', 'n', 'o'},        // 6
            {'p', 'q', 'r', 's'},    // 7
            {'t', 'u', 'v'},        // 8
            {'w', 'x', 'y', 'z'}    // 9
    };

    public static void main(String[] args) {
        ArrayList<String> words = getValidT9Words("33835676368", AssortedMethods.getTrieDictionary());
        for (String w : words) {
            System.out.println(w);
        }
    }

    static ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", trie.getRoot(), results);
        return results;
    }

    static void getValidWords(String number, int index, String prefix, TrieNode trieNode, ArrayList<String> results) {
        if (index == number.length()) {
            if (trieNode.isTerminates()) {
                results.add(prefix);
            }
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter : letters) {
                TrieNode child = trieNode.getChild(letter);
                if (child != null) {
                    getValidWords(number, index + 1, prefix + letter, child, results);
                }
            }
        }
    }

    static char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }
}
