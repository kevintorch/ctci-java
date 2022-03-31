package big_o;

public class SumOfNNumbers {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("f of " + n + " is");
        System.out.println(f(n));

    }

    static int sum(int n) {
        if (n <= 0) return 0;
        return n + sum(n - 1);
    }

    static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i + (i + 1);
        }
        return sum;
    }

    static int f(int n) {
        if (n <= 1) return 1;
        return f(n - 1) + f(n - 1);
    }


}
