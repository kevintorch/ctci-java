package sorting_searching;

public class RadixSort {
    public static void main(String[] args) {

    }

    public static void radixSort(int[] array, int radix) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        int exp = 1;
        while ((max - min) / exp >= 1) {
            countSortByDigit(array, radix, exp, min);
            exp *= radix;
        }
    }

    public static void countSortByDigit(int[] arr, int radix, int exp, int min) {
        int[] buckets = new int[radix];
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }
        int bucket;
        for (int i = 0; i < arr.length; i++) {
            bucket = (((arr[i] - min) / exp) % radix);
            buckets[bucket]++;
        }

        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            bucket = (((arr[i] - min) / exp) % radix);
            out[--buckets[bucket]] = arr[i];
        }

        System.arraycopy(out, 0, arr, 0, arr.length);
    }

//    public static int getMax(int[] array) {
//        int max = array[0];
//        int index = 1;
//        while (index < array.length) {
//            if (array[index] > max) max = array[index];
//            index++;
//        }
//        return max;
//    }
}
