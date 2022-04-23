package moderate.Q21_Sum_Swap;

import java.util.HashSet;

public class QuestionB {
    public static void main(String[] args) {

    }

    // O(A + B)
    public static int[] findSwapValues(int[] a, int[] b) {
        Integer target = getTarget(a, b);
        if (target == null) return null;
        return findDifferenceValues(a, b, target);
    }

    private static int[] findDifferenceValues(int[] a, int[] b, Integer target) {
        HashSet<Integer> contents = getContents(b);
        for (int value : a) {
            int diff = value - target;
            if (contents.contains(diff)) {
                return new int[]{diff, value};
            }
        }
        return null;
    }

    private static HashSet<Integer> getContents(int[] a) {
        HashSet<Integer> table = new HashSet<>();
        for (int value : a) {
            table.add(value);
        }
        return table;
    }

    private static Integer getTarget(int[] a, int[] b) {
        int sumA = sum(a);
        int sumB = sum(b);
        if ((sumA - sumB) % 2 != 0) return null;
        return (sumA - sumB) / 2;
    }

    private static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
