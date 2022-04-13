package moderate.Q06_smallest_difference;

// Given two arrays of integers, compute the pair of values (one value in each array)
// with the smallest (non-negative) difference. Return the difference.
//
// EXAMPLE
// Input: {l, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
// Output: 3. That is, the pair (11, 8).

import java.util.Arrays;

public class Question {
    public static void main(String[] args) {

    }

    public static int smallestDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int n = 0;
        int m = 0;
        while (n < a.length && m < b.length) {
            if (Math.abs(a[n] - b[m]) < min) {
                min = a[n] - b[m];
            }

            if (a[n] < b[m]) {
                n++;
            } else {
                m++;
            }
        }
        return min;
    }

}
