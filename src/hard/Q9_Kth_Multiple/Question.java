package hard.Q9_Kth_Multiple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
// Note that 3, 5, and 7 do not have to be factors, but it should not have any other prime factors.
// For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
//
// kth smallest number that is in the form 3a * 5b * 7c
public class Question {
    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(i + " : " + getKthMagicNumber(i));
//        }

        int i = 3;
        System.out.println(i + " : " + getKthMagicNumber(i));
    }

    private static void print(ArrayList<?> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static int getKthMagicNumber(int k) {
        ArrayList<Integer> possibilities = allPossibleKFactors(k);
        print(possibilities);
        Collections.sort(possibilities);
        print(possibilities);
        return possibilities.get(k);
    }

    public static ArrayList<Integer> allPossibleKFactors(int k) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int a = 0; a <= k; a++) { // 3
            int powA = (int) Math.pow(3, a);
            for (int b = 0; b <= k; b++) { // 5
                int powB = (int) Math.pow(5, b);
                for (int c = 0; c <= k; c++) { // 7
                    int powC = (int) Math.pow(7, c);
                    int value = powA * powB * powC;
                    if (value < 0 || powA == Integer.MAX_VALUE || powB == Integer.MAX_VALUE || powC == Integer.MAX_VALUE) {
                        value = Integer.MAX_VALUE;
                    }
                    values.add(value);
                }
            }
        }
        return values;
    }

}
