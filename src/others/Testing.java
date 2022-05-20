package others;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        String[] a = {"K", "A", "S", "P", "T"};
        List<String> list = Arrays.asList(a);
        List<String> strings = removeRange(new LinkedList<>(list), 0, 1);
        System.out.println("Removed Range: " + Arrays.toString(strings.toArray()));
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

    private static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
