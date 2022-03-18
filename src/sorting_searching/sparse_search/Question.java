package sorting_searching.sparse_search;

public class Question {
    public static void main(String[] args) {

    }

    public static int search(String[] arr, String str, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;

        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < low && right > high) {
                    return -1;
                } else if (left >= low && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= high && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                right++;
                left--;
            }
        }

        if (arr[mid].equals(str)) {
            return mid;
        } else if (arr[mid].compareTo(str) < 0) {
            return search(arr, str, mid + 1, high);
        } else {
            return search(arr, str, low, mid - 1);
        }
    }

    public static int binarySearch(String[] a, String d) {
        if (a == null || d == null || d.equals("")) return -1;
        return search(a, d, 0, a.length - 1);
    }
}
