package hard.Q11_Word_Distance;

import others.AssortedMethods;
import others.HashMapList;

import java.util.ArrayList;

// You have a large text file containing words. Given any two words,
// find the shortest distance (in terms of number of words) between them in the file.
// If the operation will be repeated many times for the same file (but different pairs of words),
// can you optimize your solution?
public class Question {

    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        String word1 = "river";
        String word2 = "life";
        HashMapList<String, Integer> locations = getWordLocations(wordlist);
        LocationPair pair = findClosest(word1, word2, locations);
        System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + pair.toString());
    }

    private static HashMapList<String, Integer> getWordLocations(String[] words) {
        HashMapList<String, Integer> locations = new HashMapList<>();
        for (int i = 0, length = words.length; i < length; i++) {
            locations.put(words[i], i);
        }
        return locations;
    }

    private static LocationPair findMinDistancePair(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1 == null || list1.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }

        int index1 = 0;
        int index2 = 0;
        LocationPair best, current;
        best = current = new LocationPair(list1.get(0), list2.get(0));
        while (index1 < list1.size() && index2 < list2.size()) {
            current.setLocations(list1.get(index1), list2.get(index2));
            best.updateWithMin(current);
            if (current.location1 < current.location2) {
                index1++;
            } else {
                index2++;
            }
        }

        return best;
    }

    public static LocationPair findClosest(String word1, String word2, HashMapList<String, Integer> locations) {
        ArrayList<Integer> locations1 = locations.get(word1);
        ArrayList<Integer> locations2 = locations.get(word2);
        return findMinDistancePair(locations1, locations2);
    }
}
