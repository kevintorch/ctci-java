package hard.Q09_Kth_Multiple;

import java.util.LinkedList;
import java.util.Queue;

public class QuestionB {
    public static void main(String[] args) {
//        for (int i = 0; i < 14; i++) {
//
//        }
        int i = 4;
        System.out.println(i + " : " + getKthMagicNumber(i));
    }

    public static void printQueue(Queue<Integer> q, int x) {
        System.out.print(x + ": ");
        for (Integer a : q) {
            System.out.print(a / x + "(" + a + ")" + ", ");
        }
        System.out.println();
    }

    public static int removeMin(Queue<Integer> q) {
        int min = q.peek();
        for (Integer v : q) {
            if (min > v) {
                min = v;
            }
        }
        while (q.contains(min)) {
            q.remove(min);
        }
        return min;
    }

    public static void addProducts(Queue<Integer> q, int v) {
        q.add(v * 3);
        q.add(v * 5);
        q.add(v * 7);
    }

    public static int getKthMagicNumber(int k) {
        if (k < 0) {
            return 0;
        }
        int val = 1;
        Queue<Integer> q = new LinkedList<>();
        addProducts(q, 1);
        printQueue(q, val);
        for (int i = 0; i < k; i++) { // Start at 1 since we've already done one iteration
            val = removeMin(q);
            addProducts(q, val);
            printQueue(q, val);
        }
        return val;
    }
}
