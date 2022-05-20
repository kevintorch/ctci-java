package hard.Q02_Suffle;

// Write a method to shuffle a deck of cards. It must be a perfect shuffle-in other words,
// each of the 52! permutations of the deck has to be equally likely.
// Assume that you are given a random number generator which is perfect.


import helpers.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

public class Question {

    static Random rand;

    public static int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) {
            return cards;
        }

        /* shuffle elements 0 through index - 1 */
        shuffleArrayRecursively(cards, i - 1);
        if (rand == null)
            rand = new Random();
        int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)

        /* Swap element k and index */
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        /* Return shuffled array */
        return cards;
    }

    public static void shuffleArrayIteratively(int[] cards) {
        if (rand == null)
            rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }

    public static void shuffle(int[] a) {
        if (rand == null)
            rand = new Random();
        for (int i = a.length; i > 1; i--) {
            ArrayUtil.swap(a, i - 1, rand.nextInt(i));
        }
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3};
        System.out.println(Arrays.toString(cards));
        shuffle(cards);
        System.out.println(Arrays.toString(cards));
    }
}
