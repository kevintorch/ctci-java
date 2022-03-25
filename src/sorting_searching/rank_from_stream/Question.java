package sorting_searching.rank_from_stream;

public class Question {

    private static RankNode root = null;

    public static void main(String[] args) {

    }

    public static void track(int d) {
        if (root == null) {
            root = new RankNode(d);
        } else {
            root.insert(d);
        }
    }

    public static int getRankOfNumber(int d) {
        return root.getRank(d);
    }

}
