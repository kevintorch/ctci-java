package hard.Q17_Multi_Search;

import java.util.ArrayList;

public class Trie {
    TrieNode root = new TrieNode();

    public void insert(String s, int index) {
        root.insert(s, index);
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public TrieNode getRoot() {
        return root;
    }

    public void print() {
        if (root != null) {
            System.out.println("== Map ==");
            System.out.println(root.getChildren());
            System.out.println("=====");
            System.out.println();
            root.print();
        }
    }
}
