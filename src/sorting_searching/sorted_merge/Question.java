package sorting_searching.sorted_merge;

// You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
// Write a method to merge B into A in sorted order.

import java.util.Arrays;

public class Question {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] a, int[] b, int countA, int countB) {
        int indexA = countA - 1;
        int indexB = countB - 1;
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexA + indexB + 1] = a[indexA];
                indexA--;
            } else {
                a[indexA + indexB + 1] = b[indexB];
                indexB--;
            }
        }
    }

}
