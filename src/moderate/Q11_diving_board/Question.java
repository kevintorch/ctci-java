package moderate.Q11_diving_board;


// You are building a diving board by placing a bunch of planks of wood end-to-end.
// There are two types of planks, one of length shorter and one of length longer.
// You must use exactly K planks of wood. Write a method to generate all possible lengths for the diving board.


import java.util.HashSet;

// TODO:- Didn't Understand the solution.

public class Question {

    public static final int counter = 0;

    public static void main(String[] args) {
        HashSet<Integer> lengths = allLengths(12, 1, 3);
        System.out.println(lengths);
        System.out.println(counter);
    }

    public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    private static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        System.out.println("K: " + k + ", total: " + total + " shorter: " + shorter + " longer: " + longer);
        if (k == 0) {
            lengths.add(total);
            System.out.println(lengths);
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }


}
