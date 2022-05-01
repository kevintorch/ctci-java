package moderate.Q24_Pairs_With_Sum;

public class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public static Pair create(int x, int y) {
        return new Pair(x, y);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
