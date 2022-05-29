package hard.Q17_Multi_Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final HashMap<Character, TrieNode> children;
    private final ArrayList<Integer> indices;

    public TrieNode() {
        children = new HashMap<>();
        indices = new ArrayList<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void insert(String s, int index) {
        if (s == null) return;
        indices.add(index);
        if (s.length() > 0) {
            char value = s.charAt(0);
            TrieNode child;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new TrieNode();
                children.put(value, child);
            }
            String remainder = s.substring(1);
            child.insert(remainder, index + 1);
        } else {
            children.put('\0', null);
        }
    }

    public ArrayList<Integer> search(String s) {
        if (s == null || s.length() == 0) return indices;

        char first = s.charAt(0);
        if (children.containsKey(first)) {
            String remainder = s.substring(1);
            return getChild(first).search(remainder);
        }
        return null;
    }

    public boolean terminates() {
        return children.containsKey('\0');
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public void print() {
        for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
            System.out.print(entry.getKey());
            if (entry.getValue() != null) {
                System.out.print(" -> ");
                entry.getValue().print();
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return children.toString();
    }
}
