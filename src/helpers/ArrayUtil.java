package helpers;


public class ArrayUtil {

    public static <T> T[] reverse(T[] a, int startIndex, int endIndex) {
        if (a == null || endIndex - startIndex < 2) return a;
        swap(a, startIndex, endIndex - 1);
        return reverse(a, startIndex + 1, endIndex - 1);
    }

    public static <T> void print(T[] a) {
        System.out.println(toString(a));
    }

    public static <T> String toString(T[] a) {
        if (a == null) return "null";
        int iMax = a.length - 1;

        StringBuilder arrayString = new StringBuilder();
        arrayString.append('[');
        for (int i = 0; i < a.length; i++) {
            arrayString.append(a[i]);
            if (i != iMax) {
                arrayString.append(", ");
            }
        }
        arrayString.append(']');
        return arrayString.toString();
    }

    private static <T> void swap(T[] a, int e1, int e2) {
        T temp = a[e1];
        a[e1] = a[e2];
        a[e2] = temp;
    }
}
