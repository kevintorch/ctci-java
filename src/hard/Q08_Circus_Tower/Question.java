package hard.Q08_Circus_Tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// A circus is designing a tower routine consisting of people standing atop one another's shoulders.
// For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her.
// Given the heights and weights of each person in the circus,
// write a method to compute the largest possible number of people in such a tower.

// TODO:- Understand this.
public class Question {
    public static ArrayList<HtWt> initialize() {
        ArrayList<HtWt> items = new ArrayList<>();

        HtWt item = new HtWt(65, 60);
        items.add(item);

        item = new HtWt(70, 150);
        items.add(item);

        item = new HtWt(56, 90);
        items.add(item);

        item = new HtWt(75, 190);
        items.add(item);

        item = new HtWt(60, 95);
        items.add(item);

        item = new HtWt(68, 110);
        items.add(item);

        item = new HtWt(35, 65);
        items.add(item);

        item = new HtWt(40, 60);
        items.add(item);

        item = new HtWt(45, 63);
        items.add(item);

        return items;
    }

    public static void printList(ArrayList<HtWt> list) {
        StringBuilder builder = new StringBuilder();
        if (list != null)
            for (HtWt item : list) {
                builder.append(item.toString()).append(" ");
            }
        else
            builder.append("null");

        System.out.println(builder);
    }

    public static void main(String[] args) {
        ArrayList<HtWt> items = initialize();
        ArrayList<HtWt> solution = longestIncreasingSeq(items);
        printList(solution);
    }

    public static ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> items) {
        Collections.sort(items);
        System.out.println("Sorted List:");
        printList(items);
        return bestSeqAtIndex(items, new ArrayList<>(), 0);
    }

    private static ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index) {
        System.out.println();
        if (index >= array.size()) return sequence;

        HtWt value = array.get(index);
        StringBuilder builder = appendSpaces(new StringBuilder(), index);
        ArrayList<HtWt> bestWith = null;
        if (canAppend(sequence, value)) {
            @SuppressWarnings("unchecked")
            ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>) sequence.clone();
            sequenceWith.add(value);
            appendList(builder, sequenceWith);
            bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
        }
        ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);
//        System.out.println("Best Without: ");
//        printList(bestWithout);
        ArrayList<HtWt> max = max(bestWith, bestWithout);
        System.out.println(builder);
        System.out.println("Max: ");
        printList(max);
        return max;
    }

    private static void appendList(StringBuilder builder, ArrayList<HtWt> sequenceWith) {
        builder.append(Arrays.toString(sequenceWith.toArray()));
    }

    private static StringBuilder appendSpaces(StringBuilder builder, int index) {
        int spaces = 0;
        while (spaces != index) {
            builder.append(' ');
            spaces++;
        }
        builder.append(':');
        return builder;
    }

    private static boolean canAppend(ArrayList<HtWt> seq, HtWt value) {
        if (seq == null) return false;
        if (seq.size() == 0) return true;
        HtWt last = seq.get(seq.size() - 1);
        return last.isBefore(value);
    }

    private static ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) return seq2;
        if (seq2 == null) return seq1;
        return seq1.size() < seq2.size() ? seq2 : seq1;
    }
}
