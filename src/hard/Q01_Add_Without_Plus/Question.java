package hard.Q01_Add_Without_Plus;

//  Write a function that adds two numbers. You should not use+ or any arithmetic operators.

public class Question {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE - 50;
        int b = 92;
        int sum = add(a, b);
        int intendedSum = a + b;
        if (sum != intendedSum) {
            System.out.println("ERROR");
        } else {
            System.out.println("SUCCESS");
        }
        System.out.println(a + " + " + b + " = " + sum + " vs " + intendedSum);
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static int addRecur(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return addRecur(sum, carry);

    }
}
