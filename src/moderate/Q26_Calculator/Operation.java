package moderate.Q26_Calculator;

public class Operation {
    private final int leftOperand;
    private final int rightOperand;
    private final Operator operator;

    public Operation(int leftOperand, int rightOperand, Operator operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double perform() {
        if (operator == Operator.ADD) {
            return Math.addExact(leftOperand, rightOperand);
        }
        if (operator == Operator.SUBTRACT) {
            return Math.subtractExact(leftOperand, rightOperand);
        }
        if (operator == Operator.MULTIPLY) {
            return Math.multiplyExact(leftOperand, rightOperand);
        }
        return (double) leftOperand / rightOperand;
    }
}
