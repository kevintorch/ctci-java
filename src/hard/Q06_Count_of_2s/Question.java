package hard.Q06_Count_of_2s;


import static java.lang.Math.pow;

// Write a method to count the number of 2s between 0 and n.
public class Question {
    public static void main(String[] args) {
        int number = 61253;
        int powerOf10 = (int) pow(10, 3);
        int nexPowerOf10 = powerOf10 * 10;
        System.out.println(number + ": " + (number & nexPowerOf10) / powerOf10);
        System.out.println("No of 2s: " + count2sInRange(999999999));
    }

    public static int count2sInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(number, digit);
        }
        return count;
    }

    public static int count2sInRangeAtDigit(int number, int d) {
        int powerOf10 = (int) pow(10, d);
        int nexPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nexPowerOf10;
        int roundUp = roundDown + nexPowerOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown + right + 1;
        } else {
            return roundUp / 10;
        }
    }

}
