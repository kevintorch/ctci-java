package sorting_searching.find_dups;

// You have an array with all the numbers from 1 to N, where N is at most 32,000.
// The array may have duplicate entries and you do not know what N is.
// With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?

import others.AssortedMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(30, 1, 30);
        System.out.println(Arrays.toString(array));
        Integer[] dupInts = checkDuplicates(array);
        System.out.println(Arrays.toString(dupInts));
    }

    public static Integer[] checkDuplicates(int[] arr) {
        BitSet bs = new BitSet(32000);
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                dups.add(num);
            } else {
                bs.set(num0);
            }
        }
        return dups.toArray(Integer[]::new);
    }
}
