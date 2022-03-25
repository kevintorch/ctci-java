package sorting_searching.peaks_and_valleys;

import java.util.Arrays;
import java.util.Comparator;

public class Question {
    public static void main(String[] args) {

    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void sortPeakValley(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i += 2) {
            swap(arr, i - 1, i);
        }
    }

    private static class PeakValleyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }
}
