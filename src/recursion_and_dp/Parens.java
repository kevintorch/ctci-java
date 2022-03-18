package recursion_and_dp;

// Implement an algorithm to print all valid (i.e., properly opened and closed)
// combinations of n pairs of parentheses.

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Parens {
    public static void main(String[] args) {
        String[] list = generateParens(4).toArray(String[]::new);
        String[] list2 = createParens(4).toArray(String[]::new);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + "  :  " + list2[i]);
        }
//        for (String s : list) {
//            System.out.println(s);
//        }
        System.out.println(list.length);
        System.out.println(list2.length);
    }

    public static Collection<String> createParens(int count) {
        char[] str = new char[count * 2];
        Collection<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    private static void addParen(Collection<String> collection, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;

        if (leftRem == 0 && rightRem == 0) {
            collection.add(String.valueOf(str));
        } else {
            str[index] = '(';
            addParen(collection, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParen(collection, leftRem, rightRem - 1, str, index + 1);
        }
    }

    public static Collection<String> generateParens(int remaining) {
        Collection<String> collection = new HashSet<>();
        if (remaining == 0) {
            collection.add("");
        } else {
            Collection<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        collection.add(s);
                    }
                }
                collection.add("()" + str);
            }
        }
        return collection;
    }

    private static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1);
        return left + "()" + right;
    }

}
