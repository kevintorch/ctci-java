package others;

import java.util.HashMap;

public class TrieNode {
    private final HashMap<Character, TrieNode> children;
    private boolean terminates = false;
    private char character;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;

        char firstChar = word.charAt(0);
        TrieNode child = getChild(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }

    public char getChar() {
        return character;
    }

    public boolean isTerminates() {
        return terminates;
    }

    public void setTerminates(boolean t) {
        terminates = t;
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }
}
