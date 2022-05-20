package hard.Q10_Majority_Element;

// A majority element is an element that makes up more than half of the items in an array.
// Given a positive integers array, find the majority element. If there is no majority element, return -1.
// Do this in O(N) time and 0(1) space.
public class Question {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int majorityElement = findMajorityElement(a);
        System.out.println(majorityElement);
    }

    public static int findMajorityElement(int[] a) {
        if (a == null || a.length == 0) return -1;
        int e = -1;
        for (int k : a) {
            int count = countOfk(a, k);
            if (count > a.length / 2) {
                e = k;
                break;
            }
        }
        return e;
    }

    private static int countOfk(int[] a, int k) {
        int count = 0;
        for (int e : a) {
            if (e == k) count++;
        }
        return count;
    }
}
