package moderate.Q26_Calculator;

// Given an arithmetic equation consisting of positive integers, +,-,* and / (no parentheses), compute the result.
//
// EXAMPLE
// Input: 2*3+5/6*3+15
// Output: 23.5

public class Question {
    public static void main(String[] args) {

    }


    public static double compute(String exp) {
        double value = -1;
        for (char token : exp.toCharArray()) {


        }

        if (value == -1) throw new IllegalArgumentException("illegal expression");
        else return value;
    }
}
