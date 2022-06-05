package hard.Q26_Sparse_Similarity;

import java.util.ArrayList;

public class Document {
    public int id;
    public ArrayList<Integer> words;

    public Document(int id, ArrayList<Integer> words) {
        this.id = id;
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getWords() {
        return words;
    }

    public int size() {
        return words == null ? 0 : words.size();
    }
}
