package hard.Q20_Continuous_Median;

import java.util.Comparator;

public class MaxHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
    }
}
