package hard.Q1_Add_Without_Plus;

public class Tester {
    public static void main(String[] args) {
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                int sumA = Question.add(a, b);
                int sumB = Question.addRecur(a, b);
                int sum = a + b;
                if (sumA != sum || sumB != sum) {
                    System.out.println("ERROR: " + a + " + " + b + " = " + sum + " vs: " + sumA + ", " + sumB);
                } else {
                    System.out.println("SUCCESS: " + a + " + " + b + " = " + sum);
                }
            }
        }
    }
}
