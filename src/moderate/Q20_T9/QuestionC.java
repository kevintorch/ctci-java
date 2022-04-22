package moderate.Q20_T9;

import others.AssortedMethods;
import others.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionC {

    public static char[][] t9Letters = {
            null,                    // 0
            null,                    // 1
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
        HashMapList<String, String> dictionary = initializeDictionary(AssortedMethods.getListOfWords());
        ArrayList<String> words = getValidT9Words("8733", dictionary);
        for (String w : words) {
            System.out.println(w);
        }
    }

    private static ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
        return dictionary.get(numbers);
    }

    static HashMapList<String, String> initializeDictionary(String[] words) {
        HashMapList<String, String> numberToWordsDictionary = new HashMapList<>();
        HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap(words);
        for (String word : words) {
            String number = convertToT9(word, letterToNumberMap);
            numberToWordsDictionary.put(number, word);
        }

        return numberToWordsDictionary;
    }

    private static HashMap<Character, Character> createLetterToNumberMap(String[] words) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];
            if (letters != null) {
                for (char letter : letters) {
                    char c = Character.forDigit(i, 10);
                    map.put(letter, c);
                }
            }
        }
        return map;
    }

    private static String convertToT9(String word, HashMap<Character, Character> letterToNumberMap) {
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if (letterToNumberMap.containsKey(ch)) {
                char digit = letterToNumberMap.get(ch);
                sb.append(digit);
            }
        }

        return sb.toString();
    }


}
