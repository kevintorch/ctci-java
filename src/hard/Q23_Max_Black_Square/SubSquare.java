package hard.Q23_Max_Black_Square;

public class SubSquare {
    int row, column, size;

    public SubSquare(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
    }

    public void print() {
        System.out.println("(" + row + ", " + column + ", " + size + ")");
    }
}
