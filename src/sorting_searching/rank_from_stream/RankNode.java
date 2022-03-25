package sorting_searching.rank_from_stream;

public class RankNode {
    int data;
    RankNode left;
    RankNode right;
    int left_size;

    public RankNode(int data) {
        this.data = data;
    }

    public void insert(int n) {
        if (n > data) {
            if (right == null) {
                right = new RankNode(n);
            } else {
                right.insert(n);
            }
            left_size++;
        } else {
            if (left == null) {
                left = new RankNode(n);
            } else {
                left.insert(n);
            }
        }
    }

    public int getRank(int d) {
        if (d == data) {
            return left_size;
        } else if (d < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int right_rank = right == null ? -1 : right.getRank(d);
            if (right_rank == -1) {
                return -1;
            } else {
                return left_size + 1 + right_rank;
            }
        }
    }
}
