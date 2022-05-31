package hard.Q18_Shortest_Supersequence;

import java.util.*;

public class QuestionD {
    public static void main(String[] args) {

    }


    public static Range shortestSupersequence(int[] big, int[] small) {
        ArrayList<Queue<Integer>> locations = getLocationsForElements(big, small);
        return getShortestClosure(locations);
    }

    private static Range getShortestClosure(ArrayList<Queue<Integer>> locations) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        /* Insert min element from each list. */
        for (int i = 0; i < locations.size(); i++) {
            Queue<Integer> list = locations.get(i);
            if (list == null || list.size() == 0) {
                return null;
            }
            int head = list.remove();
            minHeap.add(new HeapNode(head, i));
            max = Math.max(max, head);
        }

        int min = minHeap.peek().location;
        int bestRangeMin = min;
        int bestRangeMax = max;
        while (true) {
            /* Remove min node. */
            HeapNode n = minHeap.poll();
            Queue<Integer> list = locations.get(n.id);

            /* Compare range to best range. */
            min = n.location;
            if (max - min < bestRangeMax - bestRangeMin) {
                bestRangeMax = max;
                bestRangeMin = min;
            }

            /* If there are no more elements, then there's no more subsequences and we can break. */
            if (list.size() == 0) {
                break;
            }

            /* Add new head of list to heap. */
            n.location = list.remove();
            minHeap.add(n);
            max = Math.max(max, n.location);
        }
        return new Range(bestRangeMin, bestRangeMax);
    }

    private static ArrayList<Queue<Integer>> getLocationsForElements(int[] big, int[] small) {
        /* Initialize hash map from item value to locations. */
        HashMap<Integer, Queue<Integer>> itemLocations = new HashMap<>();
        for (int s : small) {
            Queue<Integer> queue = new LinkedList<>();
            itemLocations.put(s, queue);
        }

        /* Walk through big array, adding the item locations to hash map */
        for (int i = 0; i < big.length; i++) {
            Queue<Integer> queue = itemLocations.get(big[i]);
            if (queue != null) {
                queue.add(i);
            }
        }

        return new ArrayList<>(itemLocations.values());
    }
}
