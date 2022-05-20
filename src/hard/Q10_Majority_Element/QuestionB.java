package hard.Q10_Majority_Element;

// TODO:- Understand the concept behind this from book.
public class QuestionB {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int majorityElement = findMajorityElement(a);
        System.out.println(majorityElement);
    }

    public static int findMajorityElement(int[] a) {
        if (a == null || a.length == 0) return -1;
        int candidate = getCandidate(a);
        return validate(a, candidate) ? candidate : -1;
    }

    public static int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;
        for (int n : array) {
            if (count == 0) {
                majority = n;
            }
            if (n == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    private static boolean validate(int[] a, int k) {
        int count = 0;
        for (int e : a) {
            if (e == k) count++;
        }
        return count > a.length / 2;
    }
}
