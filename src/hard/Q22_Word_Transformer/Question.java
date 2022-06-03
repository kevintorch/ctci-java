package hard.Q22_Word_Transformer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question {
    public static void main(String[] args) {
        String[] dictionary = {"DAMP", "LIKE", "LAMP", "LIMP", "LIME"};

        List<String> transformWord = transformWord("DAMP", "LIKE", dictionary);
        System.out.println(transformWord);
    }

    public static List<String> transformWord(String word, String finalWord, String[] words) {
        LinkedList<String> wordList = new LinkedList<>();
        if (word.equals(finalWord)) {
            wordList.add(word);
            return wordList;
        }
        HashSet<String> dictionary = setupDictionary(words);
        wordList.add(word);


        Queue<CharacterNode> characterNodes = buildCharList(finalWord);

        while (!characterNodes.isEmpty()) {
            CharacterNode characterNode = characterNodes.peek();
            String lastWord = wordList.peekLast();
            String w =
                    lastWord.substring(0,
                            characterNode.index) + characterNode.mChar + lastWord.substring(characterNode.index + 1);
            if (dictionary.contains(w)) {
                characterNodes.remove();
                wordList.add(w);
            }
        }
//        HashMap<Integer, Character> remainingTable = new HashMap<>();
//        putCharAt(remainingTable, finalWord, 0);
//        int length = word.length();
//        for (int i = 0; i < length; i++) {
//            char c = finalWord.charAt(i);
//            String[] wordsArray = combinationsOf(word, c);
//            for (String w : wordsArray) {
//                if (dictionary.contains(w)){
//                    wordList.add(w);
//                }
//            }
//        }

        return wordList;
    }

    private static Queue<CharacterNode> buildCharList(String word) {
        Queue<CharacterNode> characterNodes = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            characterNodes.add(new CharacterNode(i, word.charAt(i)));
        }
        return characterNodes;
    }

    private static String[] combinationsOf(String word, char c) {
        String[] combinations = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            combinations[i] = word.substring(0, i) + c + word.substring(i + 1);
        }
        return combinations;
    }

    public static HashSet<String> setupDictionary(String[] words) {
        HashSet<String> dic = new HashSet<>();
        for (String w : words) {
            dic.add(w.toLowerCase());
        }
        return dic;
    }

    private static class CharacterNode {
        int index;
        char mChar;

        public CharacterNode(int index, char mChar) {
            this.index = index;
            this.mChar = mChar;
        }
    }
}
