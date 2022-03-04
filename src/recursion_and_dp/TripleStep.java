package recursion_and_dp;

// A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

import java.util.Arrays;

public class TripleStep {
    public static void main(String[] args) {
    }

    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public static int countWays2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWaysMemo(n, memo);
    }

    public static int countWaysMemo(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWaysMemo(n - 1, memo) +
                    countWaysMemo(n - 2, memo) +
                    countWaysMemo(n - 3, memo);
            return memo[n];
        }
    }
}
