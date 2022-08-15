package sorting_searching.sorting_algos;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] a = {5, 11, 19, 21, 22, 24, 2, 6, 10, 11, 12, 18};

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + end / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int[] leftHelper = new int[leftSize + 1];
        int[] rightHelper = new int[rightSize + 1];

        System.arraycopy(a, left, leftHelper, 0, leftSize);
        System.arraycopy(a, middle + 1, rightHelper, 0, rightSize);

        leftHelper[leftSize] = Integer.MAX_VALUE;
        rightHelper[rightSize] = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(leftHelper));
        System.out.println(Arrays.toString(rightHelper));

        int i = 0;
        int j = 0;

        for (int k = left; k <= right; k++) {
            if (leftHelper[i] <= rightHelper[j]) {
                a[k] = leftHelper[i];
                i++;
            } else {
                a[k] = rightHelper[j];
                j++;
            }
        }
    }
}
