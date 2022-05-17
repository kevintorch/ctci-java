package hard.Q7_Baby_Names;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Each year, the government releases a list of the 10,000 most common baby names and
// their frequencies (the number of babies with that name).
// The only problem with this is that some names have multiple spellings.
// For example, "John" and "Jon" are essentially the same name but would be listed separately in the list.
// Given two lists, one of names/frequencies and the other of pairs of equivalent names,
// write an algorithm to print a new list of the true frequency of each name.
// Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and Johnny are synonyms.
// (It is both transitive and symmetric.) In the final list, any name can be used as the "real" name.
// EXAMPLE
// Input:
//   Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
//   Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
// Output: John (27), Kris (36)
public class Question {
    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<>();

        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms =
                {{"John", "Jonathan"},
                        {"Jonathan", "Johnny"},
                        {"Chris", "Kris"},
                        {"Brian", "Bryan"}};

        HashMap<String, Integer> finalList = trulyMostPopular(names, synonyms);
        for (Entry<String, Integer> entry : finalList.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + ": " + frequency);
        }
    }


    public static HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> nameFreq, String[][] synonyms) {
        HashMap<String, NameSet> groups = constructGroups(nameFreq);
        mergeClasses(groups, synonyms);
        return convertToMap(groups);
    }

    /* Read through (name, frequency) pairs and initialize a mapping
     * of names to NameSets (equivalence classes).*/
    public static HashMap<String, NameSet> constructGroups(HashMap<String, Integer> names) {
        HashMap<String, NameSet> groups = new HashMap<>();
        for (Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            NameSet group = new NameSet(name, frequency);
            groups.put(name, group);
        }
        printMap(groups);
        System.out.println();
        return groups;
    }

    private static void printMap(Map<String, ?> map) {
        for (Entry<String, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public static void mergeClasses(HashMap<String, NameSet> groups, String[][] synonyms) {
        System.out.println(Arrays.deepToString(synonyms));
        System.out.println();
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            NameSet set1 = groups.get(name1);
            NameSet set2 = groups.get(name2);
            if (set1 != set2) {
                /* Always merge the smaller set into the bigger one. */
                NameSet smaller = set2.size() < set1.size() ? set2 : set1;
                NameSet bigger = set2.size() < set1.size() ? set1 : set2;

//                System.out.println("Smaller Set: " + smaller);
//                System.out.println("Bigger Set: " + bigger);
                /* Merge lists */
                Set<String> otherNames = smaller.getNames();
                int frequency = smaller.getFrequency();
                bigger.copyNamesWithFrequency(otherNames, frequency);

//                System.out.println("New Bigger Set: " + bigger);

                /* Update mapping */
                for (String name : otherNames) {
                    groups.put(name, bigger);
//                    System.out.println("Updated: " + name + " --> " + bigger);
                }
                printMap(groups);
            }
            System.out.println();
        }
    }

    public static HashMap<String, Integer> convertToMap(HashMap<String, NameSet> groups) {
        HashMap<String, Integer> list = new HashMap<>();
        for (NameSet group : groups.values()) {
            list.put(group.getRootName(), group.getFrequency());
        }
        return list;
    }
}
