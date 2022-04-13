package moderate.sub_sort;


// Given an array of integers, write a method to find indices m and n such that if you sorted
// elements m through n , the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};

        Indices r = findUnsortedSequence(array);
        System.out.println(r);
        System.out.println(array[r.startIndex] + ", " + array[r.endIndex]);
    }

    // My Solution
    public static Indices findUnsortedSequence(int[] array) {
        Indices indices = new Indices(0, array.length - 1);

        while (indices.startIndex < indices.endIndex) {
            int min = minElement(array, indices.startIndex + 1, indices.endIndex);
            boolean noMoreMinElement = false;
            boolean noMoreMaxElement = false;
            if (array[indices.startIndex] <= min) {
                indices.startIndex++;
            } else {
                noMoreMinElement = true;
            }
            int max = maxElement(array, indices.startIndex, indices.endIndex - 1);
            if (array[indices.endIndex] > max) {
                indices.endIndex--;
            } else {
                noMoreMaxElement = true;
            }
            if (noMoreMaxElement && noMoreMinElement) break;
        }

        return indices;
    }

    public static int maxElement(int[] array, int start, int end) {
        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return findElement(integers, start, end, (a, b) -> a > b);
    }

    public static int minElement(int[] array, int start, int end) {
        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return findElement(integers, start, end, (a, b) -> a <= b);
    }

    public static int maxElementIndex(int[] array, int start, int end) {
        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return findElement(integers, start, end, (a, b) -> a >= b);
    }

    private static <T> T findElement(T[] array, int start, int end, BiPredicate<T, T> condition) {
        T e = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (condition.test(array[i], e)) {
                e = array[i];
            }
        }
        return e;
    }

    public static int minElementIndex(int[] array, int start, int end) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
            }
        }
        return min;
    }

}
