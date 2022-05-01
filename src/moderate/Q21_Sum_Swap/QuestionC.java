package moderate.Q21_Sum_Swap;

import java.util.Arrays;

public class QuestionC {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 2, 2, 4};
        int[] array2 = {3, 3, 3, 6};
        int[] swaps = findSwapValues(array1, array2);
        if (swaps == null) {
            System.out.println("null");
        } else {
            System.out.println(swaps[0] + " " + swaps[1]);
        }
    }

    public static int[] findSwapValues(int[] a, int[] b) {
        Integer target = getTarget(a, b);
        if (target == null) return null;
        return findDifference(a, b, target);
    }

    private static int[] findDifference(int[] a, int[] b, Integer target) {
        Arrays.sort(a);
        Arrays.sort(b);
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            int diff = a[aIndex] - b[bIndex];
            if (diff == target) {
                return new int[]{a[aIndex], b[bIndex]};
            } else if (diff < target) {
                aIndex++;
            }
            bIndex++;
        }
        return null;
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
