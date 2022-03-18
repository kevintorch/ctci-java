package recursion_and_dp;

// Given an infinite number of quarters (25 cents), dimes (1O cents), nickels (5 cents), and pennies (1 cent),
// write code to calculate the number of ways of representing n cents.

public class Coins {
    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int ways = makeChange(10, denoms);
        System.out.println(ways);
    }

    public static int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;  // last denom
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static int makeChangeHelper(int total, int[] denoms, int index) {
        int coin = denoms[index];
        if (index == denoms.length - 1) { // One denom left, either you can do it or not
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        int ways = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for (int amount = 0; amount <= total; amount += coin) {
            ways += makeChangeHelper(total - amount, denoms, index + 1); // go to next denom
        }
        return ways;
    }

    public static int makeChange(int n, int[] denoms) {
        return makeChange(n, denoms, 0);
    }

    public static int makeChange2(int n, int[] denoms) {
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    private static int makeChange(int total, int[] denoms, int index, int[][] map) {
        if (map[total][index] > 0) return map[total][index];
        int coin = denoms[index];
        if (index == denoms.length - 1) { // One denom left, either you can do it or not
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        int ways = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for (int amount = 0; amount <= total; amount += coin) {
            ways += makeChangeHelper(total - amount, denoms, index + 1); // go to next denom
        }
        map[total][index] = ways;
        return ways;
    }

}
