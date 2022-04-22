package moderate.Q16_sub_sort;

public class QuestionB {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};

        long startTime = System.nanoTime();
        Indices r = findUnsortedSequence(array);
        long elapsedNanos = System.nanoTime();
        System.out.println("elapsedNanos: " + (elapsedNanos - startTime));
        System.out.println(r);
        System.out.println(array[r.startIndex] + ", " + array[r.endIndex]);
    }

    public static Indices findUnsortedSequence(int[] array) {
        int end_left = findEndOfLeftSubsequence(array);
        if (end_left >= array.length - 1) return new Indices(-1, -1);

        int start_right = findStartOfRightSubsequence(array);

        // get min & max.
        int min_index = end_left;
        int max_index = start_right;
        for (int i = end_left + 1; i < start_right; i++) {
            if (array[i] < array[min_index]) min_index = i;
            if (array[i] > array[max_index]) max_index = i;
        }

        int left_index = shrinkLeft(array, min_index, end_left);
        int right_index = shrinkRight(array, max_index, start_right);

        return new Indices(left_index, right_index);
    }

    public static int findStartOfRightSubsequence(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) return i + 1;
        }
        return 0;
    }

    public static int findEndOfLeftSubsequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return i - 1;
        }
        return array.length - 1;
    }

    public static int shrinkLeft(int[] array, int min_index, int start) {
        int comp = array[min_index];
        for (int i = start - 1; i >= 0; i--) {
            if (array[i] <= comp) return i + 1;
        }
        return 0;
    }

    public static int shrinkRight(int[] array, int max_index, int start) {
        int comp = array[max_index];
        for (int i = start; i < array.length; i++) {
            if (array[i] >= comp) return i - 1;
        }
        return array.length - 1;
    }
}
