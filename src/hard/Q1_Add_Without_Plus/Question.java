package hard.Q1_Add_Without_Plus;

//  Write a function that adds two numbers. You should not use+ or any arithmetic operators.

public class Question {
    public static void main(String[] args) {
        System.out.println(add(5, 3));
    }

    public static int add(int a, int b) { // a = 5, b = 3
        while (b != 0) {
            print(a, false);
            print(b, false);
            int sum = a ^ b;
            int carry = (a & b) << 1;
            print(sum, true);
            print(carry, true);
            a = sum;
            b = carry;
        }
        return a;
    }

    private static void print(int n, boolean inBinary) {
        System.out.println(inBinary ? Integer.toBinaryString(n) : n);
    }

    public static int addRecur(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return addRecur(sum, carry);

    }
}
