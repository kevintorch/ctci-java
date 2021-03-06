package sorting_searching.search_in_rotated_array;

// Given a sorted array of n integers that has been rotated an unknown number of times,
// write code to find an element in the array.
// You may assume that the array was originally sorted in increasing order.
//
// EXAMPLE
// Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
// Output: 8 (the index of 5 in the array)

public class Question {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 2, 2, 2, 2, 2, 2};

        System.out.println(indexOf(a, 2));
        System.out.println(indexOf(a, 3));
        System.out.println(indexOf(a, 4));
        System.out.println(indexOf(a, 1));
        System.out.println(indexOf(a, 8));
    }

    public static int indexOf(int[] arr, int data) {
        return search(arr, 0, arr.length - 1, data);
    }

    public static int search(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

        /* While there may be an inflection point due to the rotation, either the left or
         * right half must be normally ordered.  We can look at the normally ordered half
         * to make a determination as to which half we should search.
         */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else { // order disturbed.
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[right]) { // Right is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else { // order disturbed.
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result != -1) {
                    return result;
                } else {
                    return search(a, mid + 1, right, x);
                }
            }
        }
        return -1;
    }

    public static int indexOf(int[] arr, int data, int low, int high) {
        int mid = (low + high) >>> 1;
        if (data == arr[mid]) return mid;
        if (high < low) return -1;

        if (arr[low] < arr[mid]) {
            if (data >= arr[low] && data < arr[mid]) {
                return indexOf(arr, data, low, mid - 1);
            } else {
                return indexOf(arr, data, mid + 1, high);
            }
        } else if (arr[mid] < arr[high]) {
            if (data > arr[mid] && data <= arr[high]) {
                return indexOf(arr, data, mid + 1, high);
            } else {
                return indexOf(arr, data, low, mid - 1);
            }
        } else if (arr[low] == arr[mid]) {
            if (arr[mid] != arr[high]) {
                return indexOf(arr, data, mid + 1, high);
            } else {
                int result = indexOf(arr, data, low, mid - 1);
                if (result == -1) {
                    return indexOf(arr, data, mid + 1, high);
                } else {
                    return result;
                }
            }
        }

        return -1;
    }
}
