package sorting_searching.peaks_and_valleys;

import java.util.Arrays;

public class QuestionB {
    public static void main(String[] args) {
        int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
        System.out.println(Arrays.toString(array));
        sortPeakValley(array);
        System.out.println(Arrays.toString(array));
        System.out.println(confirmValleyPeak(array));
    }

    public static void sortPeakValley(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            int maxIndex = maxIndex(arr, i - 1, i, i + 1);
            if (maxIndex != i) {
                swap(arr, i, maxIndex);
            }
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int maxIndex(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        if (bValue == max) return b;
        return c;
    }


    public static boolean confirmValleyPeak(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int prev = array[i - 1];
            int curr = array[i];
            int next = array[i + 1];

            /* Alternative Code:
             *
             *  if (prev > curr || curr < next) && (prev < curr || curr > next) {
             *       return false;
             *  }
             *
             * */
            if (prev <= curr && curr >= next) {
                continue;
            } else if (prev >= curr && curr <= next) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }
}
