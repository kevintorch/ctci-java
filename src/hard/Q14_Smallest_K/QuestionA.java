package hard.Q14_Smallest_K;

import java.util.Arrays;

public class QuestionA {
    public static void main(String[] args) {

    }

    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) throw new IllegalArgumentException();
        Arrays.sort(array);
        int[] smallest = new int[k];
        System.arraycopy(array, 0, smallest, 0, k);
        return smallest;
    }
}
