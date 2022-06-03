package hard.Q18_Shortest_Supersequence;

import java.util.HashMap;

public class CountedLookup {
    HashMap<Integer, Integer> lookup = new HashMap<>();
    int fulfilled = 0;

    public CountedLookup(int[] array) {
        for (int e : array) {
            lookup.put(e, 0);
        }
    }

    public boolean contains(int y) {
        return lookup.containsKey(y);
    }

    public void incrementIfFound(int v) {
        if (!contains(v)) return;
        if (lookup.getOrDefault(v, 0) == 0) {
            fulfilled += 1;
        }
        lookup.put(v, lookup.getOrDefault(v, 0) + 1);
    }

    public void decrementIfFound(int v) {
        if (!contains(v)) return;
        lookup.put(v, lookup.getOrDefault(v, 0) - 1);
        if (lookup.getOrDefault(v, 0) == 0) {
            fulfilled -= 1;
        }
    }

    public boolean areAllFulfilled() {
        return fulfilled == lookup.keySet().size();
    }
}
