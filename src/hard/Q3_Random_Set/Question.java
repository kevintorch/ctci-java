package hard.Q3_Random_Set;

// Write a method to randomly generate a set of m integers from an array of size n.
// Each element must have equal probability of being chosen.

import others.AssortedMethods;

import java.util.Random;

public class Question {
    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 13, 14, 15, 8, 9};
        System.out.println(AssortedMethods.arrayToString(cards));
        int[] set = randomSetRecur(cards, cards.length, cards.length - 1);
        System.out.println(AssortedMethods.arrayToString(set));
    }

    public static int[] randomSetRecur(int[] a, int size, int i) {
        if (i + 1 > size) {
            int[] randomSet = randomSetRecur(a, size, i - 1);
            Random rand = new Random();
            int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
            if (k < size) {
                randomSet[k] = a[i];
            }
            return randomSet;
        }
        return a;
    }

    public static int[] randomSet(int[] a, int size) {
        int[] randomSet = new int[size];

        System.arraycopy(a, 0, randomSet, 0, size);

        Random rand = new Random();

        /* Go through rest of original array. */
        for (int i = size; i < a.length; i++) {
            int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
            if (k < size) {
                randomSet[k] = a[i];
            }
        }

        return randomSet;
    }

}
