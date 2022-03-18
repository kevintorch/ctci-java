package helpers;


public class ArrayUtil {

    public static <T> T[] reverse(T[] a) {
        if (a == null) return null;
        return reverse(a, 0, a.length - 1);
    }

    public static <T> T[] reverse(T[] a, int start, int end) {
        if (a == null || end - start < 1) return a;
        swap(a, start, end);
        return reverse(a, start + 1, end - 1);
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

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
