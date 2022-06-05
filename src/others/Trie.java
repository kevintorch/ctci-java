package others;

import java.util.ArrayList;

public class Trie {
    private final TrieNode root;

    /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
    public Trie(String[] list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (char ch : prefix.toCharArray()) {
            lastNode = lastNode.getChild(ch);
            if (lastNode == null) return false;
        }
        return !exact || lastNode.isTerminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }
}
