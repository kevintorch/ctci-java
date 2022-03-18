package sorting_searching.sorted_search;

// You are given an array-like data structure Listy which lacks a size method.
// It does, however, have an elementAt(i) method that returns the element at index i in 0(1) time.
// If i is beyond the bounds of the data structure, it returns -1.
// (For this reason, the data structure only supports positive integers.)
// Given a Listy which contains sorted, positive integers, find the index at which an element x occurs.
// If x occurs multiple times, you may return any index.

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(indexOfList(list, a));
        }
        System.out.println(indexOfList(list, 15));
    }

    public static int indexOfList(Listy listy, int data) {
        int i = 1;
        while (listy.elementAt(i) != -1 && listy.elementAt(i) < data) {
            i <<= 1;
        }
        return binarySearch(listy, data, i / 2, i);
    }

    public static int binarySearch(Listy list, int value, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
