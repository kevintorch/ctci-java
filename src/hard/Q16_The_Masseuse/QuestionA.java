package hard.Q16_The_Masseuse;

import java.util.ArrayList;
import java.util.List;

public class QuestionA {
    private static final List<Integer> bestWithList = new ArrayList<>(8);

    public static void main(String[] args) {
        int[] massages = {30, 15, 60, 75, 45, 15, 15, 45};
        System.out.println(maxMinutes(massages));
    }

    public static int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0);
    }

    public static int maxMinutes(int[] massages, int index) {
        if (index >= massages.length) {
            return 0;
        }


        int massage = massages[index];
        int bestWith = massage + maxMinutes(massages, index + 2);
        int bestWithout = maxMinutes(massages, index + 1);

        return Math.max(bestWithout, bestWith);
    }
}
