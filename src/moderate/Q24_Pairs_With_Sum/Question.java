package moderate.Q24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    public static void main(String[] args) {
        int[] test = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        ArrayList<Pair> pairs = findSumPairs(test, 8);
        for (Pair p : pairs) {
            System.out.println(p.toString());
        }
    }

    public static ArrayList<Pair> findSumPairs(int[] a, int targetSum) {
        ArrayList<Pair> sumPairs = new ArrayList<>();
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int i : a) {
            int comp = targetSum - i;
            if (table.getOrDefault(comp, 0) > 0) {
                sumPairs.add(Pair.create(i, comp));
                adjustValueBy(table, comp, -1);
            } else {
                adjustValueBy(table, i, 1);
            }
        }
        return sumPairs;
    }

    private static void adjustValueBy(HashMap<Integer, Integer> map, int key, int delta) {
        map.put(key, map.getOrDefault(key, 0) + delta);
    }
}
