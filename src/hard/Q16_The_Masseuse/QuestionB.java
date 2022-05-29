package hard.Q16_The_Masseuse;


public class QuestionB {

    public static void main(String[] args) {
        int[] massages = {2 * 15, 1 * 15, 4 * 15, 5 * 15, 3 * 15, 1 * 15, 1 * 15, 3 * 15};
        System.out.println(maxMinutesItr(massages));
    }

    public static int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0, new int[massages.length]);
    }

    public static int maxMinutes(int[] massages, int index, int[] memo) {
        if (index >= massages.length) return 0;

        if (memo[index] > 0) return memo[index];

        int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
        int bestWithout = maxMinutes(massages, index + 1, memo);
        memo[index] = Math.max(bestWithout, bestWith);

        return memo[index];
    }

    public static int maxMinutesItr(int[] massages) {

        int[] memo = new int[massages.length];
        memo[0] = massages[0];
        memo[1] = massages[1];
        for (int i = 2; i < massages.length; i++) {
            if (memo[i] == 0) {
                int bestWith = massages[i] + memo[i - 2];
                int bestWithout = memo[i - 1];
                memo[i] = Math.max(bestWithout, bestWith);
            }
        }
        return memo[memo.length - 1];
    }
}
