package moderate.diving_board;

import java.util.HashSet;

public class QuestionB {
    public static void main(String[] args) {

    }

    static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        return lengths;
    }

    static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
        System.out.println("K: " + k);
        if (k == 0) {
            lengths.add(total);
            System.out.println(lengths);
            return;
        }
        String key = k + " " + total;
        System.out.println("Key: " + key);
        if (visited.contains(key)) {
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }
}
