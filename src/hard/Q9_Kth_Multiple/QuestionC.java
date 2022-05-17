package hard.Q9_Kth_Multiple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QuestionC {
    public static void main(String[] args) {
//        for (int i = 0; i < 14; i++) {
//            System.out.println(i + " : " + getKthMagicNumber(i));
//        }
        int i = 5;
        System.out.println(i + " : " + getKthMagicNumber(i));
    }

    public static void printQueue(Queue<Integer> q, int x) {
//        System.out.print(x + ": ");
//        for (Integer a : q) {
//            System.out.print(a / x + ", ");
//        }
        System.out.println(Arrays.toString(q.toArray()));
    }

    public static int getKthMagicNumber(int k) {
        if (k < 0) {
            return 0;
        }
        int val = 0;
        Queue<Integer> queue3 = new LinkedList<>();
        Queue<Integer> queue5 = new LinkedList<>();
        Queue<Integer> queue7 = new LinkedList<>();
        queue3.add(1);
//        printQueue(queue3, 1);
        for (int i = 0; i <= k; i++) { // Include 0th iteration through kth iteration
            int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
            int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
            int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));
            if (val == v3) {
                queue3.remove();
                queue3.add(3 * val);
                queue5.add(5 * val);
            } else if (val == v5) {
                queue5.remove();
                queue5.add(5 * val);
            } else {
                queue7.remove();
            }
            queue7.add(7 * val);

            printQueue(queue3, val);
            printQueue(queue5, val);
            printQueue(queue7, val);
        }
        return val;
    }
}
