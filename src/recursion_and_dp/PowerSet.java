package recursion_and_dp;

// Write a method to return all subsets of a set.

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets2(list);
        System.out.println(subsets);
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);

            // index element to every subsets of next index element.
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    // Combinatorics

    public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        int max = 1 << set.size(); // Compute 2^n
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

}
