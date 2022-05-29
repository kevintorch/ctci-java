package hard.Q18_Shortest_Supersequence;

public class QuestionA {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
        int[] set = {1, 5, 9};
        System.out.println(array.length);
        Range shortest = shortestRange(array, set);
        System.out.println(shortest.getStart() + ", " + shortest.getEnd());
    }

    public static Range shortestRange(int[] bigArray, int[] smallArray) {
        int bestStart = -1;
        int bestEnd = -1;
        for (int i = 0; i < bigArray.length; i++) {
            int closureEnd = findClosure(bigArray, smallArray, i);
            if (closureEnd == -1) break;
            if (bestStart == -1 || closureEnd - i < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = closureEnd;
            }
        }
        if (bestStart < 0 || bestEnd < 0) {
            return null;
        }
        return new Range(bestStart, bestEnd);
    }

    private static int findClosure(int[] bigArray, int[] smallArray, int offset) {
        int max = -1;
        for (int j : smallArray) {
            int nextOccurrence = findNextOccurrence(bigArray, j, offset);
            if (nextOccurrence == -1) return -1;
            max = Math.max(max, nextOccurrence);
        }
        return max;
    }

    private static int findNextOccurrence(int[] bigArray, int e, int offset) {
        while (offset < bigArray.length) {
            if (bigArray[offset] == e) {
                return offset;
            }
            offset++;
        }
        return -1;
    }
}
