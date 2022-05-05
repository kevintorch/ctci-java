package moderate.Q01_number_swapper;

import java.util.Arrays;

public class NumberSwapper {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 56};
        swap(a, 0, 3);
        System.out.println(Arrays.toString(a));
        boolean[] b = {true, false, false, true, true, true};
        swap(b, 0, 2);
        System.out.println(Arrays.toString(b));
    }

    public static void swap(int[] a, int i, int j) {
        System.out.format("%s ^ %s => %s%n", bin(a[i]), bin(a[j]), bin(a[i] ^ a[j]));
        a[j] = a[i] ^ a[j];
        System.out.format("%s ^ %s => %s%n", bin(a[i]), bin(a[j]), bin(a[i] ^ a[j]));
        a[i] = a[i] ^ a[j];
        System.out.format("%s ^ %s => %s%n", bin(a[i]), bin(a[j]), bin(a[i] ^ a[j]));
        a[j] = a[i] ^ a[j];
    }

    public static void swap(boolean[] a, int i, int j) {
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
    }

    private static String bin(int i) {
        return Integer.toBinaryString(i);
    }
}
