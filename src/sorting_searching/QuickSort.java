package sorting_searching;

import static helpers.ArrayUtil.swap;

public class QuickSort {
    public static void main(String[] args) {

    }

    public static void quickSort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(Integer[] arr, int leftIndex, int rightIndex) {
        if (arr == null) return;
        int index = partition(arr, leftIndex, rightIndex);

        if (leftIndex < index - 1) {
            quickSort(arr, leftIndex, index - 1);
        }
        if (index < rightIndex) {
            quickSort(arr, index, rightIndex);
        }
    }

    public static int partition(Integer[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;

            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
