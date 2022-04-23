package moderate.Q21_Sum_Swap;

public class Question {
    public static void main(String[] args) {

    }


    public static int[] findSwapValues(int[] a1, int[] a2) {
        Integer target = getTarget(a1, a2);
        if (target == null) return null;
        for (int one : a1) {
            for (int two : a2) {
                if ((one - two) == target) {
                    return new int[]{one, two};
                }
            }
        }
        return null;
    }

    private static Integer getTarget(int[] a, int[] b) {
        int sumA = sum(a);
        int sumB = sum(b);
        if ((sumA - sumB) % 2 != 0) return null;
        return (sumA - sumB) / 2;
    }

    private static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

}
