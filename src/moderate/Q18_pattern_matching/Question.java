package moderate.Q18_pattern_matching;


// You are given two strings, pattern and value. The pattern string consists of just the letters a and b,
// describing a pattern within a string. For example, the string catcatgocatgo matches the pattern aabab
// (where cat is a and go is b). It also matches patterns like a, ab, and b.
// Write a method to determine if value matches pattern.

public class Question {
    public static void main(String[] args) {

    }

    public static boolean doesPatternMatches(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;

        int size = value.length();
        for (int mainSize = 0; mainSize < size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart < size; altStart++) {
                for (int altEnd = altStart; altEnd < size; altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static String buildFromPattern(String pattern, String main, String alt) {
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

}
