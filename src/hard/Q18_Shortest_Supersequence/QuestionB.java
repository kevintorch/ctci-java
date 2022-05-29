package hard.Q18_Shortest_Supersequence;

public class QuestionB {
    public static void main(String[] args) {
        int[] array = {9, 5, 1, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
        int[] set = {1, 5, 9};
        System.out.println(array.length);
        Range shortest = shortestRange(array, set);
        System.out.println(shortest.getStart() + ", " + shortest.getEnd());
    }

    public static Range shortestRange(int[] bigArray, int[] smallArray) {
        int[][] occurrences = findOccurrences(bigArray, smallArray);
        int[] closures = findClosures(occurrences);
        return getShortestClosure(closures);
    }

    public static int[] findClosures(int[][] occurrences) {
        int[] closures = new int[occurrences.length];
        for (int i = 0; i < occurrences.length; i++) {
            closures[i] = maxOf(occurrences[i]);
        }
        return closures;
    }

    public static int maxOf(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int e : a) {
            max = Math.max(e, max);
        }
        return max;
    }

    public static Range getShortestClosure(int[] a) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) break;
            int current = a[i] - i;
            if (bestStart == -1 || current < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = a[i];
            }
        }
        return new Range(bestStart, bestEnd);
    }

    public static int[][] findOccurrences(int[] bigArray, int[] smallArray) {
        int[][] closures = new int[smallArray.length][bigArray.length];

        for (int i = 0; i < bigArray.length; i++) {
            for (int j = 0; j < smallArray.length; j++) {
                closures[j][i] = nextOccurrence(bigArray, smallArray[j], i);
            }
        }

        return closures;
    }

    public static int nextOccurrence(int[] bigArray, int e, int offset) {
        while (offset < bigArray.length) {
            if (bigArray[offset] == e) return offset;
            offset++;
        }
        return -1;
    }
}
