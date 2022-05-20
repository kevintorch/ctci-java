package hard.Q08_Circus_Tower;

public class HtWt implements Comparable<HtWt> {
    private final int ht;
    private final int wt;

    public HtWt(int ht, int wt) {
        this.ht = ht;
        this.wt = wt;
    }

    public int getHt() {
        return ht;
    }

    public int getWt() {
        return wt;
    }

    @Override
    public String toString() {
        return "(" + ht + ", " + wt + ")";
    }

    public boolean isBefore(HtWt other) {
        return ht < other.ht && wt < other.wt;
    }

    @Override
    public int compareTo(HtWt second) {
        if (this.ht != second.ht) {
            return Integer.compare(this.ht, second.ht);
        } else {
            return Integer.compare(this.wt, second.wt);
        }
    }
}
