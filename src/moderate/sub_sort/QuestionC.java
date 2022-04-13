package moderate.sub_sort;

public class QuestionC {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};
        int[] array2 = {5, 7, 12, 9, 43, 23, 55, 95};
        Indices r = findUnsortedSequence(array2);
        System.out.println(r);
        System.out.println(array2[r.startIndex] + ", " + array2[r.endIndex]);
    }

    public static Indices findUnsortedSequence(int[] array) {
        int leftSequenceEnd = findLeftSequenceEnd(array);
        int rightSequenceStart = findRightSequenceStart(array);
        return new Indices(leftSequenceEnd, rightSequenceStart);
    }

    public static int findRightSequenceStart(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max > array[i]) {
                index = i;
            }
            max = Math.max(max, array[i]);
        }
        return index;
    }

    public static int findLeftSequenceEnd(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (min <= array[i]) {
                index = i;
            }
            min = Math.min(min, array[i]);
        }
        return index;
    }
}
