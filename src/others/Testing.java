package others;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        String[] a = {"K", "A", "S", "P", "T"};
        List<String> list = Arrays.asList(a);
        List<String> strings = removeRange(new LinkedList<>(list), 0, 1);
        System.out.println("Removed Range: " + Arrays.toString(strings.toArray()));

        int[] barChart = {2, 5, -1, 6, 0, 4};
        printBarchart(barChart);
    }

    public static <T> List<T> removeRange(List<T> list, int start, int end) {
        if (isEmpty(list) || start < 0 || end < 0 || start >= list.size() || end >= list.size())
            return new ArrayList<>();

        if (start > end) return removeRange(list, end, start);

        List<T> newList = new ArrayList<>();
        while (start <= end) {
            newList.add(list.remove(start));
            start++;
        }
        return newList;
    }

    // O (A + AT) ; A = Size of array, T = Size of the biggest column.
    private static void printBarchart(int[] cols) {
        System.out.println(Arrays.toString(cols));
        int chartHeight = maxColSize(cols);
        while (chartHeight > 0) {
            for (int col : cols) {
                if (col < chartHeight) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
            chartHeight--;
        }
    }

    private static int maxColSize(int[] cols) {
        int max = Integer.MIN_VALUE;
        for (int col : cols) max = Math.max(col, max);
        return max;
    }

    private static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
