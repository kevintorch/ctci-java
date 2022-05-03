package moderate.Q26_Calculator;

public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK;

    public boolean hasHigherPrecedenceOver(Operator other) {
        return other != null && this.precedenceLevel() > other.precedenceLevel();
    }

    public int precedenceLevel() {
        if (this == ADD || this == SUBTRACT) return 1;
        return 2;
    }
}
