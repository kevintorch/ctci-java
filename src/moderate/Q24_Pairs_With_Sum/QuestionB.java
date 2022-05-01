package moderate.Q24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionB {
    public static void main(String[] args) {
        int[] test = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        ArrayList<Pair> pairs = findSumPairs(test, 8);
        for (Pair p : pairs) {
            System.out.println(p.toString());
        }
    }

    public static ArrayList<Pair> findSumPairs(int[] a, int sum) {
        Arrays.sort(a);
        ArrayList<Pair> pairs = new ArrayList<>();

        int first = 0;
        int last = a.length - 1;

        while (first < last) {

            int i = a[first];
            int j = a[last];

            int s = i + j;
            if (s == sum) {
                pairs.add(Pair.create(i, j));
                first++;
                last--;
            } else {
                if (s < sum) {
                    first++;
                } else last--;
            }
        }

        return pairs;
    }
}
