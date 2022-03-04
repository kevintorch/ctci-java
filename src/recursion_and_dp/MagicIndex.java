package recursion_and_dp;

// A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i.
// Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

public class MagicIndex {
    public static void main(String[] args) {

    }

    public static int findMagicIndex(int[] arr) {
        return findMagicIndex(arr, 0, arr.length - 1);
    }

    public static int findMagicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return findMagicIndex(arr, start, mid - 1);
        } else {
            return findMagicIndex(arr, mid + 1, end);
        }
    }

    public static int magicFast(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        if (midIndex == midValue) return midIndex;

        // Search Left.
        int min = Math.min(midIndex - 1, midValue);
        int magic = magicFast(arr, start, min);
        if (magic != -1) return magic;

        int max = Math.max(midIndex + 1, midValue);
        return magicFast(arr, max, end);
    }
}
